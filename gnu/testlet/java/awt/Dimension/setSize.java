/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Dimension;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;

public class setSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dimension d = new Dimension();
        d.setSize(1, 2);
        harness.check(d.getWidth() == 1.0);
        harness.check(d.getHeight() == 2.0);
        d.setSize(5.0, 10.0);
        harness.check(d.getWidth() == 5.0);
        harness.check(d.getHeight() == 10.0);
        double w = 2.147583647E9;
        double h = 2.147683647E9;
        d.setSize(w, h);
        harness.check(d.getWidth() == 2.147483647E9);
        harness.check(d.getHeight() == 2.147483647E9);
        boolean pass = false;
        try {
            d.setSize(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

