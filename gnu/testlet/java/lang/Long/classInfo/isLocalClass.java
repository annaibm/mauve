/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isLocalClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Long o = new Long(42L);
        Class<?> c = o.getClass();
        harness.check(!c.isLocalClass());
    }
}

