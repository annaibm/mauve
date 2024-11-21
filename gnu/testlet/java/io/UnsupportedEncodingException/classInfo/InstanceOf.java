/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UnsupportedEncodingException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedEncodingException o = new UnsupportedEncodingException("xyzzy");
        harness.check(o instanceof UnsupportedEncodingException);
        harness.check(o instanceof IOException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

