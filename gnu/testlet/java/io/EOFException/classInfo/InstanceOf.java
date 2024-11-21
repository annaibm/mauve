/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.EOFException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.EOFException;
import java.io.IOException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EOFException o = new EOFException("xyzzy");
        harness.check(o instanceof EOFException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

