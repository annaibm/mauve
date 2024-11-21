/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.SyncFailedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.SyncFailedException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SyncFailedException o = new SyncFailedException("xyzzy");
        harness.check(o instanceof SyncFailedException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

