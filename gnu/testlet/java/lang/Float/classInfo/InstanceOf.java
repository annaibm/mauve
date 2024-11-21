/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Float o = new Float(42.0f);
        harness.check(o instanceof Float);
        harness.check(o instanceof Number);
        harness.check(o instanceof Object);
    }
}

