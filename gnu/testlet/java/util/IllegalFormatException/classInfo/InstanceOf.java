/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;
import java.util.FormatFlagsConversionMismatchException;
import java.util.IllegalFormatCodePointException;
import java.util.IllegalFormatException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.check(harness, new DuplicateFormatFlagsException("string"));
        this.check(harness, new FormatFlagsConversionMismatchException("string", 'c'));
        this.check(harness, new IllegalFormatCodePointException(42));
    }

    public void check(TestHarness harness, Throwable t) {
        harness.check(t instanceof IllegalFormatException);
        harness.check(t instanceof IllegalArgumentException);
        harness.check(t instanceof RuntimeException);
        harness.check(t instanceof Exception);
        harness.check(t instanceof Throwable);
        harness.check(t instanceof Object);
    }
}

