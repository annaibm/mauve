/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Dimension;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;

public class getSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dimension d1 = new Dimension(11, 22);
        Dimension d2 = d1.getSize();
        harness.check(d2.width == 11);
        harness.check(d2.height == 22);
        d2.width = 1;
        d2.height = 2;
        harness.check(d1.width == 11);
        harness.check(d1.height == 22);
    }
}

