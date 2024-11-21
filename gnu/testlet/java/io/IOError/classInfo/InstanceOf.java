/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOError;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOError o = new IOError(null);
        harness.check(o instanceof IOError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

