/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Introspector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.Introspector.getBeanInfo2_2TestClass;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;

public class getBeanInfo2_2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.propertyTest(harness);
    }

    void propertyTest(TestHarness harness) {
        BeanInfo bi = null;
        Class<getBeanInfo2_2TestClass> testClass = getBeanInfo2_2TestClass.class;
        Method[] expectedMethods = null;
        try {
            expectedMethods = new Method[]{testClass.getMethod("setSomething1", Integer.TYPE, Integer.TYPE, Integer.TYPE), testClass.getMethod("getSomething2", String.class, String.class, String.class), testClass.getMethod("isSomething3", String.class, String.class, String.class)};
        }
        catch (NoSuchMethodException nsme) {
            harness.fail("TEST_PREPARATION_NOSUCHMETHODEXCEPTION");
        }
        for (int i = 0; i < expectedMethods.length; ++i) {
            harness.check(expectedMethods[i] != null, "TEST_PREPARATION_METHOD_INSTANCE_AVAILABLE");
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
        for (int i = 0; i < expectedMethods.length; ++i) {
            harness.check(this.containsMethod(methodDescriptors, (Method)expectedMethods[i]), "EXPECTED_METHOD_AVAILABLE: " + expectedMethods[i].getName());
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

