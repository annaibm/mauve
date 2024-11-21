/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.WriteAbortedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.WriteAbortedException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        WriteAbortedException o = new WriteAbortedException("xyzzy", new Exception("e"));
        harness.check(o instanceof WriteAbortedException);
        harness.check(o instanceof ObjectStreamException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

