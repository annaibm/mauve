/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class getFlatnessSq
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.chkeps(QuadCurve2D.getFlatnessSq(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), 0.0);
        this.chkeps(QuadCurve2D.getFlatnessSq(10.0, -20.0, 3.0, 4.0, 5.0, 6.0), 5.483594864479315);
        double[] d = new double[]{2.0, 100.0, -200.0, 30.0, 44.0, 5.0, 600.0};
        this.chkeps(QuadCurve2D.getFlatnessSq(d, 1), 1659.6470089749782);
        this.chkeps(new QuadCurve2D.Double().getFlatnessSq(), 0.0);
        this.chkeps(new QuadCurve2D.Double(9.0, 8.0, 1.0, 2.0, -4.0, 0.0).getFlatnessSq(), 0.8412017167381975);
    }

    private void chkeps(double a, double b) {
        if (Math.abs(a - b) > 1.0E-5) {
            this.harness.check(a, b);
        } else {
            this.harness.check(true);
        }
    }
}

