/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class hash
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Short a = new Short(0);
        Short b = new Short(1);
        Short c = new Short(-1);
        Short d = new Short(Short.MAX_VALUE);
        Short e = new Short(Short.MIN_VALUE);
        harness.check(a.hashCode(), 0);
        harness.check(b.hashCode(), 1);
        harness.check(c.hashCode(), -1);
        harness.check(d.hashCode(), Short.MAX_VALUE);
        harness.check(e.hashCode(), Short.MIN_VALUE);
    }
}

