/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Integer o = new Integer(42);
        harness.check(o instanceof Integer);
        harness.check(o instanceof Number);
        harness.check(o instanceof Object);
    }
}

