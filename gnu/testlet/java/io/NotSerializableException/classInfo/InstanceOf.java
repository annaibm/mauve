/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotSerializableException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NotSerializableException o = new NotSerializableException("xyzzy");
        harness.check(o instanceof NotSerializableException);
        harness.check(o instanceof ObjectStreamException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

