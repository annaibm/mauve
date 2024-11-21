/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Dimension;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dimension d1 = new Dimension(44, 55);
        Dimension d2 = null;
        d2 = (Dimension)d1.clone();
        harness.check(d1 != d2);
        harness.check(d1.getClass().equals(d2.getClass()));
        harness.check(d1.width == d2.width);
        harness.check(d1.height == d2.height);
    }
}

