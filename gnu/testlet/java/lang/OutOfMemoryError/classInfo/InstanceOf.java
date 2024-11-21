/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.OutOfMemoryError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        OutOfMemoryError o = new OutOfMemoryError("OutOfMemoryError");
        harness.check(o instanceof OutOfMemoryError);
        harness.check(o instanceof VirtualMachineError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

