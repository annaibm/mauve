/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Runtime.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Runtime o = Runtime.getRuntime();
        harness.check(o instanceof Runtime);
        harness.check(o instanceof Object);
    }
}

