/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Dimension;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dimension d1 = new Dimension();
        Dimension d2 = new Dimension();
        harness.check(d1.equals(d2));
        harness.check(d2.equals(d1));
        harness.check(!d1.equals(null));
        d1.width = 5;
        harness.check(!d1.equals(d2));
        d2.width = 5;
        harness.check(d1.equals(d2));
        d1.height = 10;
        harness.check(!d1.equals(d2));
        d2.height = 10;
        harness.check(d1.equals(d2));
    }
}

