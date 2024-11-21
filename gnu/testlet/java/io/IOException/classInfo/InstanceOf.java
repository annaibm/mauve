/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOException o = new IOException("xyzzy");
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

