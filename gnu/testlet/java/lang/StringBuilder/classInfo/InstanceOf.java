/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuilder.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuilder o = new StringBuilder("xyzzy");
        harness.check(o instanceof StringBuilder);
        harness.check(o instanceof Object);
    }
}

