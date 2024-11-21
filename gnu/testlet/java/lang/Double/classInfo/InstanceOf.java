/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Double o = new Double(42.0);
        harness.check(o instanceof Double);
        harness.check(o instanceof Number);
        harness.check(o instanceof Object);
    }
}

