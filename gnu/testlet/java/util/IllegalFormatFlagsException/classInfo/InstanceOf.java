/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatFlagsException o = new IllegalFormatFlagsException("IllegalFormatFlagsException");
        harness.check(o instanceof IllegalFormatFlagsException);
        harness.check(o instanceof IllegalFormatException);
        harness.check(o instanceof IllegalArgumentException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

