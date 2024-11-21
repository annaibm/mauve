/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StackOverflowError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StackOverflowError o = new StackOverflowError("StackOverflowError");
        harness.check(o instanceof StackOverflowError);
        harness.check(o instanceof VirtualMachineError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

