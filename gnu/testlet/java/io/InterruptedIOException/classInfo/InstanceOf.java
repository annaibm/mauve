/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InterruptedIOException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InterruptedIOException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InterruptedIOException o = new InterruptedIOException("xyzzy");
        harness.check(o instanceof InterruptedIOException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

