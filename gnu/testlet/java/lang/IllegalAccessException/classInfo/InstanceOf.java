/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalAccessException o = new IllegalAccessException("java.lang.IllegalAccessException");
        harness.check(o instanceof IllegalAccessException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

