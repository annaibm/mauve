/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NullPointerException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NullPointerException o = new NullPointerException("java.lang.NullPointerException");
        harness.check(o instanceof NullPointerException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

