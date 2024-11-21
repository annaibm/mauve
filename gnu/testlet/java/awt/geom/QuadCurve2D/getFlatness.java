/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class getFlatness
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.chkeps(QuadCurve2D.getFlatness(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), 0.0);
        this.chkeps(QuadCurve2D.getFlatness(1.0, 2.0, 5.0, 6.0, 3.0, 4.0), 2.8284271247461903);
        this.chkeps(QuadCurve2D.getFlatness(10.0, -20.0, 3.0, 4.0, 5.0, 6.0), 2.3417076812615436);
        double[] d = new double[]{2.0, 100.0, -200.0, 30.0, 44.0, 5.0, 600.0};
        this.chkeps(QuadCurve2D.getFlatness(d, 1), 40.73876543263159);
        this.chkeps(new QuadCurve2D.Double().getFlatness(), 0.0);
        this.chkeps(new QuadCurve2D.Double(9.0, 8.0, 1.0, 2.0, -4.0, 0.0).getFlatness(), 0.9171704949125857);
    }

    private void chkeps(double a, double b) {
        if (Math.abs(a - b) > 1.0E-6) {
            this.harness.check(a, b);
        } else {
            this.harness.check(true);
        }
    }
}

