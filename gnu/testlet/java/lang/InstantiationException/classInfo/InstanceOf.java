/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InstantiationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InstantiationException o = new InstantiationException("java.lang.InstantiationException");
        harness.check(o instanceof InstantiationException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

