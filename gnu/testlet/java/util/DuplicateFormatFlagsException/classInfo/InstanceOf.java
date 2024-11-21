/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.DuplicateFormatFlagsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;
import java.util.IllegalFormatException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DuplicateFormatFlagsException o = new DuplicateFormatFlagsException("DuplicateFormatFlagsException");
        harness.check(o instanceof DuplicateFormatFlagsException);
        harness.check(o instanceof IllegalFormatException);
        harness.check(o instanceof IllegalArgumentException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

