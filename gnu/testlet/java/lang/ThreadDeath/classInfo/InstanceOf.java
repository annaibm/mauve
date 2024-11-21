/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ThreadDeath.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ThreadDeath o = new ThreadDeath();
        harness.check(o instanceof ThreadDeath);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

