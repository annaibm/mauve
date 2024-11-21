/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getFlatness
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.chkeps(CubicCurve2D.getFlatness(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), 0.0);
        this.chkeps(CubicCurve2D.getFlatness(1.0, 2.0, 5.0, 6.0, 3.0, 4.0, 7.0, 8.0), 0.0);
        this.chkeps(CubicCurve2D.getFlatness(1.0, 2.0, 3.0, 4.0, 7.0, 8.0, 5.0, 6.0), 2.8284271247461903);
        this.chkeps(CubicCurve2D.getFlatness(10.0, -20.0, 3.0, 4.0, 5.0, 6.0, 40.0, 0.0), 24.40680863391008);
        double[] d = new double[]{2.0, 100.0, -200.0, 30.0, 44.0, 5.0, 600.0, 77.0, 18981.0};
        this.chkeps(CubicCurve2D.getFlatness(d, 1), 94.04064976860437);
        this.chkeps(new CubicCurve2D.Double().getFlatness(), 0.0);
        this.chkeps(new CubicCurve2D.Double(9.0, 8.0, 1.0, 2.0, -4.0, 0.0, 1311.0, 2332.0).getFlatness(), 15.264337522473747);
    }

    private void chkeps(double a, double b) {
        if (Math.abs(a - b) > 1.0E-7) {
            this.harness.check(a, b);
        } else {
            this.harness.check(true);
        }
    }
}

