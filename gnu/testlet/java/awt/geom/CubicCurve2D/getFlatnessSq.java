/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getFlatnessSq
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.chkeps(CubicCurve2D.getFlatnessSq(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), 0.0);
        this.chkeps(CubicCurve2D.getFlatnessSq(1.0, 2.0, 5.0, 6.0, 3.0, 4.0, 7.0, 8.0), 0.0);
        this.chkeps(CubicCurve2D.getFlatnessSq(1.0, 2.0, 3.0, 4.0, 7.0, 8.0, 5.0, 6.0), 8.0);
        this.chkeps(CubicCurve2D.getFlatnessSq(10.0, -20.0, 3.0, 4.0, 5.0, 6.0, 40.0, 0.0), 595.6923076923077);
        double[] d = new double[]{2.0, 100.0, -200.0, 30.0, 44.0, 5.0, 600.0, 77.0, 18981.0};
        this.chkeps(CubicCurve2D.getFlatnessSq(d, 1), 8843.64380890131);
        this.chkeps(new CubicCurve2D.Double().getFlatnessSq(), 0.0);
        this.chkeps(new CubicCurve2D.Double(9.0, 8.0, 1.0, 2.0, -4.0, 0.0, 1311.0, 2332.0).getFlatnessSq(), 233.0);
    }

    private void chkeps(double a, double b) {
        if (Math.abs(a - b) > 1.0E-7) {
            this.harness.check(a, b);
        } else {
            this.harness.check(true);
        }
    }
}

