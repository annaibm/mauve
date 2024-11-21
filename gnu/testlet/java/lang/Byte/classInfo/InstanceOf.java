/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Byte o = new Byte(42);
        harness.check(o instanceof Byte);
        harness.check(o instanceof Number);
        harness.check(o instanceof Object);
    }
}

