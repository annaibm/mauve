/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalArgumentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalArgumentException o = new IllegalArgumentException("java.lang.IllegalArgumentException");
        Class<IllegalArgumentException> c = o.getClass();
        harness.check(c.isAssignableFrom(IllegalArgumentException.class));
    }
}

