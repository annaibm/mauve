/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharConversionException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharConversionException;
import java.io.IOException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CharConversionException o = new CharConversionException("xyzzy");
        harness.check(o instanceof CharConversionException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

