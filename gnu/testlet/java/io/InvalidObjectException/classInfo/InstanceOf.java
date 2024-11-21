/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidObjectException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InvalidObjectException o = new InvalidObjectException("xyzzy");
        harness.check(o instanceof InvalidObjectException);
        harness.check(o instanceof ObjectStreamException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

