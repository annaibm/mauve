/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Introspector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.Introspector.getBeanInfoTestClass;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class getBeanInfo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.propertyTest(harness);
    }

    void propertyTest(TestHarness harness) {
        BeanInfo bi = null;
        Class<getBeanInfoTestClass> testClass = getBeanInfoTestClass.class;
        Method readWritePropertyReadMethod = null;
        Method readWritePropertyWriteMethod = null;
        Method readOnlyPropertyReadMethod = null;
        Method writeOnlyPropertyWriteMethod = null;
        try {
            readWritePropertyReadMethod = testClass.getMethod("getCorrectProperty", new Class[0]);
            readWritePropertyWriteMethod = testClass.getMethod("setCorrectProperty", Integer.TYPE);
            readOnlyPropertyReadMethod = testClass.getMethod("getCorrectReadOnlyProperty", new Class[0]);
            writeOnlyPropertyWriteMethod = testClass.getMethod("setCorrectWriteOnlyProperty", Integer.TYPE);
        }
        catch (NoSuchMethodException nsme) {
            harness.fail("TEST_PREPARATION_NOSUCHMETHODEXCEPTION");
        }
        harness.check(readWritePropertyReadMethod != null, "TEST_PREPARATION_METHOD_INSTANCE_1");
        harness.check(readWritePropertyWriteMethod != null, "TEST_PREPARATION_METHOD_INSTANCE_2");
        harness.check(readOnlyPropertyReadMethod != null, "TEST_PREPARATION_METHOD_INSTANCE_3");
        harness.check(writeOnlyPropertyWriteMethod != null, "TEST_PREPARATION_METHOD_INSTANCE_4");
        try {
            bi = Introspector.getBeanInfo(testClass, Object.class);
        }
        catch (IntrospectionException ie) {
            harness.fail("TEST_PREPARATION_INTROSPECTION_EXCEPTION");
        }
        harness.check(bi != null, "TEST_PREPARATION_VALID_BEANINFO");
        PropertyDescriptor[] propertyDescriptors = bi.getPropertyDescriptors();
        harness.check(propertyDescriptors.length, 3, "PROPERTY_DESCRIPTORS_ARRAY: expected 3 entries");
        boolean readWritePresent = false;
        boolean readOnlyPresent = false;
        boolean writeOnlyPresent = false;
        for (int i = 0; i < 3; ++i) {
            String name2 = propertyDescriptors[i].getName();
            if (name2.equals("correctProperty")) {
                harness.check(readWritePresent, false, "READ_WRITE_PRESENT1");
                readWritePresent = true;
                harness.check(propertyDescriptors[i].getReadMethod(), readWritePropertyReadMethod, "READ_WRITE_READ_METHOD");
                harness.check(propertyDescriptors[i].getWriteMethod(), readWritePropertyWriteMethod, "READ_WRITE_WRITE_METHOD");
                continue;
            }
            if (name2.equals("correctReadOnlyProperty")) {
                harness.check(readOnlyPresent, false, "READ_ONLY_PRESENT1");
                readOnlyPresent = true;
                harness.check(propertyDescriptors[i].getReadMethod(), readOnlyPropertyReadMethod, "READ_ONLY_READ_METHOD");
                harness.check(propertyDescriptors[i].getWriteMethod(), null, "READ_ONLY_WRITE_METHOD");
                continue;
            }
            if (!name2.equals("correctWriteOnlyProperty")) continue;
            harness.check(writeOnlyPresent, false, "WRITE_ONLY_PRESENT1");
            writeOnlyPresent = true;
            harness.check(propertyDescriptors[i].getReadMethod(), null, "WRITE_ONLY_READ_METHOD");
            harness.check(propertyDescriptors[i].getWriteMethod(), writeOnlyPropertyWriteMethod, "WRITE_ONLY_WRITE_METHOD");
        }
        harness.check(readWritePresent, "READ_WRITE_PRESENT2");
        harness.check(readOnlyPresent, "READ_ONLY_PRESENT2");
        harness.check(writeOnlyPresent, "WRITE_ONLY_PRESENT2");
    }
}

