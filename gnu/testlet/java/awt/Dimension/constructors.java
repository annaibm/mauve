/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Dimension;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dimension d = new Dimension();
        harness.check(d.getWidth() == 0.0);
        harness.check(d.getHeight() == 0.0);
        d = new Dimension(5, 10);
        harness.check(d.getWidth() == 5.0);
        harness.check(d.getHeight() == 10.0);
        Dimension d1 = new Dimension(100, 200);
        Dimension d2 = new Dimension(d1);
        harness.check(d2.getWidth() == 100.0);
        harness.check(d2.getHeight() == 200.0);
        d1.width = 1;
        d1.height = 2;
        harness.check(d2.getWidth() == 100.0);
        harness.check(d2.getHeight() == 200.0);
        boolean pass = false;
        try {
            Dimension dimension = new Dimension(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

