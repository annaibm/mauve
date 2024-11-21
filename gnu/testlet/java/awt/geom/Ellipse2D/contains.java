/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testContains1(harness);
        this.testContains2(harness);
    }

    private void testContains1(TestHarness harness) {
        harness.checkPoint("contains(double, double)");
        Ellipse2D.Double e = new Ellipse2D.Double();
        harness.check(!e.contains(0.0, 0.0));
        e = new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(!e.contains(1.0, 2.0));
        harness.check(!e.contains(4.0, 2.0));
        harness.check(!e.contains(1.0, 6.0));
        harness.check(!e.contains(4.0, 6.0));
        harness.check(e.contains(2.5, 4.0));
        e = new Ellipse2D.Double(-1.0, -1.0, 2.0, 2.0);
        harness.check(e.contains(0.0, 0.0));
        harness.check(!e.contains(-1.0, 0.0));
        harness.check(!e.contains(0.0, 1.0));
        harness.check(!e.contains(0.0, -1.0));
        harness.check(!e.contains(0.0, 1.0));
        harness.check(e.contains(-0.9, 0.0));
        harness.check(e.contains(0.0, 0.9));
        harness.check(e.contains(0.0, -0.9));
        harness.check(e.contains(0.0, 0.9));
    }

    private void testContains2(TestHarness harness) {
        harness.checkPoint("contains(double, double, double, double)");
        Ellipse2D.Double e = new Ellipse2D.Double();
        harness.check(!e.contains(0.0, 0.0, 0.0, 0.0));
        e = new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(!e.contains(1.0, 2.0, 3.0, 4.0));
        harness.check(e.contains(2.5, 4.0, 1.0, 1.0));
    }
}

