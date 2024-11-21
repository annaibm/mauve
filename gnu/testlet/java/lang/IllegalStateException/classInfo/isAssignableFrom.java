/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalStateException o = new IllegalStateException("java.lang.IllegalStateException");
        Class<IllegalStateException> c = o.getClass();
        harness.check(c.isAssignableFrom(IllegalStateException.class));
    }
}

