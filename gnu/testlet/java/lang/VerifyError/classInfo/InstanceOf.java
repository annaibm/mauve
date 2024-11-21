/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.VerifyError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        VerifyError o = new VerifyError("VerifyError");
        harness.check(o instanceof VerifyError);
        harness.check(o instanceof LinkageError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

