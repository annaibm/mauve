/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalMonitorStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalMonitorStateException o = new IllegalMonitorStateException("java.lang.IllegalMonitorStateException");
        harness.check(o instanceof IllegalMonitorStateException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

