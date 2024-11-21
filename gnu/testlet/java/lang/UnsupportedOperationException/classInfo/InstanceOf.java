/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedOperationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedOperationException o = new UnsupportedOperationException("java.lang.UnsupportedOperationException");
        harness.check(o instanceof UnsupportedOperationException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

