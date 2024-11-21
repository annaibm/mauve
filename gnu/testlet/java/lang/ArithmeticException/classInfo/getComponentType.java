/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArithmeticException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getComponentType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArithmeticException o = new ArithmeticException("java.lang.ArithmeticException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getComponentType();
        harness.check(cls == null);
    }
}

