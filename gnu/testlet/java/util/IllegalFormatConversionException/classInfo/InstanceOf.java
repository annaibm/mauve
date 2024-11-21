/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatConversionException o = new IllegalFormatConversionException('a', Character.class);
        harness.check(o instanceof IllegalFormatConversionException);
        harness.check(o instanceof IllegalFormatException);
        harness.check(o instanceof IllegalArgumentException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

