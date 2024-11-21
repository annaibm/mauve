/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ThreadDeath.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInterface
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ThreadDeath o = new ThreadDeath();
        Class<?> c = o.getClass();
        harness.check(!c.isInterface());
    }
}

