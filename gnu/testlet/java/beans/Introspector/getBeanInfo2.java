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
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;

public class getBeanInfo2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.propertyTest(harness);
    }

    void propertyTest(TestHarness harness) {
        int i;
        int i2;
        BeanInfo bi = null;
        Class<getBeanInfoTestClass> testClass = getBeanInfoTestClass.class;
        Method[] expectedMethods = null;
        Method[] unexpectedMethods = null;
        try {
            expectedMethods = new Method[]{testClass.getMethod("setCorrectProperty", Integer.TYPE), testClass.getMethod("getCorrectProperty", new Class[0]), testClass.getMethod("getCorrectReadOnlyProperty", new Class[0]), testClass.getMethod("setCorrectWriteOnlyProperty", Integer.TYPE), testClass.getMethod("setSomeStaticValue", Integer.TYPE), testClass.getMethod("getSomeStaticValue", new Class[0])};
            unexpectedMethods = new Method[]{testClass.getDeclaredMethod("setSomeValue", Integer.TYPE), testClass.getDeclaredMethod("getSomeValue", new Class[0])};
        }
        catch (NoSuchMethodException nsme) {
            harness.fail("TEST_PREPARATION_NOSUCHMETHODEXCEPTION");
        }
        for (i2 = 0; i2 < expectedMethods.length; ++i2) {
            harness.check(expectedMethods[i2] != null, "TEST_PREPARATION_METHOD_INSTANCE_AVAILABLE");
        }
        for (i2 = 0; i2 < unexpectedMethods.length; ++i2) {
            harness.check(unexpectedMethods[i2] != null, "TEST_PREPARATION_METHOD_INSTANCE_AVAILABLE");
        }
        try {
            bi = Introspector.getBeanInfo(testClass, testClass.getSuperclass());
        }
        catch (IntrospectionException ie) {
            harness.fail("TEST_PREPARATION_INTROSPECTION_EXCEPTION");
        }
        harness.check(bi != null, "TEST_PREPARATION_VALID_BEANINFO");
        MethodDescriptor[] methodDescriptors = bi.getMethodDescriptors();
        harness.check(methodDescriptors.length, expectedMethods.length, "MATCH_EXPECTED_METHOD_COUNT");
        for (i = 0; i < expectedMethods.length; ++i) {
            harness.check(this.containsMethod(methodDescriptors, (Method)expectedMethods[i]), "EXPECTED_METHOD_AVAILABLE: " + expectedMethods[i].getName());
        }
        for (i = 0; i < unexpectedMethods.length; ++i) {
            harness.check(!this.containsMethod(methodDescriptors, (Method)unexpectedMethods[i]), "UNEXPECTED_METHOD_UNAVAILABE: " + unexpectedMethods[i].getName());
        }
    }

    boolean containsMethod(MethodDescriptor[] methodDescriptors, Method key) {
        for (int i = 0; i < methodDescriptors.length; ++i) {
            if (!key.equals(methodDescriptors[i].getMethod())) continue;
            return true;
        }
        return false;
    }
}

