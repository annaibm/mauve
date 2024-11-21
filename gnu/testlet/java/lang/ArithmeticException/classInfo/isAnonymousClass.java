/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArithmeticException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAnonymousClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArithmeticException o = new ArithmeticException("java.lang.ArithmeticException");
        Class<?> c = o.getClass();
        harness.check(!c.isAnonymousClass());
    }
}

