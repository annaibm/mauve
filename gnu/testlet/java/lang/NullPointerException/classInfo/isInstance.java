/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NullPointerException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NullPointerException o = new NullPointerException("java.lang.NullPointerException");
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new NullPointerException("java.lang.NullPointerException")));
    }
}

