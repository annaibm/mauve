/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Error.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Error o = new Error("Error");
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

