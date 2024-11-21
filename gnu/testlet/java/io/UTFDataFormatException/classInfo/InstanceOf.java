/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UTFDataFormatException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.UTFDataFormatException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UTFDataFormatException o = new UTFDataFormatException("xyzzy");
        harness.check(o instanceof UTFDataFormatException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

