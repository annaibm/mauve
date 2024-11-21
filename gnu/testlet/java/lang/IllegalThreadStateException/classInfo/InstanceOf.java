/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalThreadStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalThreadStateException o = new IllegalThreadStateException("java.lang.IllegalThreadStateException");
        harness.check(o instanceof IllegalThreadStateException);
        harness.check(o instanceof IllegalArgumentException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

