/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnknownError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnknownError o = new UnknownError("UnknownError");
        harness.check(o instanceof UnknownError);
        harness.check(o instanceof VirtualMachineError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

