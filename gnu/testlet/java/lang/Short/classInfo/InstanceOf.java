/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Short o = new Short("42");
        harness.check(o instanceof Short);
        harness.check(o instanceof Number);
        harness.check(o instanceof Object);
    }
}

