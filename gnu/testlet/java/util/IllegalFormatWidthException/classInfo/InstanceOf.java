/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatWidthException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatException;
import java.util.IllegalFormatWidthException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatWidthException o = new IllegalFormatWidthException(42);
        harness.check(o instanceof IllegalFormatWidthException);
        harness.check(o instanceof IllegalFormatException);
        harness.check(o instanceof IllegalArgumentException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

