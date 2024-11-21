/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.CloneNotSupportedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CloneNotSupportedException o = new CloneNotSupportedException("java.lang.CloneNotSupportedException");
        harness.check(o instanceof CloneNotSupportedException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

