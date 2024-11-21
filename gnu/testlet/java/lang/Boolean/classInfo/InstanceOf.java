/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean o = new Boolean(true);
        harness.check(o instanceof Boolean);
        harness.check(o instanceof Object);
    }
}

