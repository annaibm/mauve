/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalStateException o = new IllegalStateException("java.lang.IllegalStateException");
        harness.check(o instanceof IllegalStateException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

