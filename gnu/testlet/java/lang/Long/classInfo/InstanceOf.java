/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Long o = new Long(42L);
        harness.check(o instanceof Long);
        harness.check(o instanceof Number);
        harness.check(o instanceof Object);
    }
}

