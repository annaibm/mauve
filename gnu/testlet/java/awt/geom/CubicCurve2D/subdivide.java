/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;
import java.util.Arrays;

public class subdivide
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.test_array();
        this.test_curve2();
        this.test_curve3();
    }

    private void test_array() {
        this.harness.checkPoint("array");
        double[] src = new double[]{7.0, 7.0, 1.5, 2.0, 3.0, 4.0, -5.0, 6.0, 9.0, 13.0};
        double[] left = new double[15];
        CubicCurve2D.subdivide(src, 2, left, 1, left, 7);
        this.harness.check(Arrays.equals(left, new double[]{0.0, 1.5, 2.0, 2.25, 3.0, 0.625, 4.0, 0.5625, 5.625, 0.5, 7.25, 2.0, 9.5, 9.0, 13.0}));
        try {
            CubicCurve2D.subdivide(src, 0, null, 0, null, 0);
            this.harness.check(true);
        }
        catch (Exception ex) {
            this.harness.check(false);
        }
        src = new double[8];
        left = new double[8];
        double[] right = new double[8];
        CubicCurve2D.subdivide(src, 0, left, 0, right, 0);
        this.harness.check(Arrays.equals(left, new double[8]));
        this.harness.check(Arrays.equals(left, right));
    }

    private void test_curve2() {
        this.harness.checkPoint("curve2");
        CubicCurve2D.Double src = new CubicCurve2D.Double(42.0, 24.0, 123.0, 321.0, -78011.0, -11087.0, 41.0, 28.0);
        CubicCurve2D.Double left = new CubicCurve2D.Double();
        CubicCurve2D.Float right = new CubicCurve2D.Float();
        src.subdivide(left, right);
        this.chkeps(((CubicCurve2D)left).getX1(), 42.0);
        this.chkeps(((CubicCurve2D)left).getY1(), 24.0);
        this.chkeps(((CubicCurve2D)left).getCtrlX1(), 82.5);
        this.chkeps(((CubicCurve2D)left).getCtrlY1(), 172.5);
        this.chkeps(((CubicCurve2D)left).getCtrlX2(), -19430.75);
        this.chkeps(((CubicCurve2D)left).getCtrlY2(), -2605.25);
        this.chkeps(((CubicCurve2D)left).getX2(), -29197.625);
        this.chkeps(((CubicCurve2D)left).getY2(), -4030.75);
        this.chkeps(((CubicCurve2D)right).getX1(), -29197.625);
        this.chkeps(((CubicCurve2D)right).getY1(), -4030.75);
        this.chkeps(((CubicCurve2D)right).getCtrlX1(), -38964.5);
        this.chkeps(((CubicCurve2D)right).getCtrlY1(), -5456.25);
        this.chkeps(((CubicCurve2D)right).getCtrlX2(), -38985.0);
        this.chkeps(((CubicCurve2D)right).getCtrlY2(), -5529.5);
        this.chkeps(((CubicCurve2D)right).getX2(), 41.0);
        this.chkeps(((CubicCurve2D)right).getY2(), 28.0);
    }

    private void test_curve3() {
        this.harness.checkPoint("curve3");
        CubicCurve2D.Double src = new CubicCurve2D.Double(23.0, -23.0, 42.0, -42.0, 1968.5, -1968.5, 68.0, 96.0);
        CubicCurve2D.Float left = new CubicCurve2D.Float();
        CubicCurve2D.Float right = new CubicCurve2D.Float();
        CubicCurve2D.subdivide(src, left, right);
        this.chkeps(((CubicCurve2D)left).getX1(), 23.0);
        this.chkeps(((CubicCurve2D)left).getY1(), -23.0);
        this.chkeps(((CubicCurve2D)left).getCtrlX1(), 32.5);
        this.chkeps(((CubicCurve2D)left).getCtrlY1(), -32.5);
        this.chkeps(((CubicCurve2D)left).getCtrlX2(), 518.875);
        this.chkeps(((CubicCurve2D)left).getCtrlY2(), -518.875);
        this.chkeps(((CubicCurve2D)left).getX2(), 765.3125);
        this.chkeps(((CubicCurve2D)left).getY2(), -744.8125);
        this.chkeps(((CubicCurve2D)right).getX1(), 765.3125);
        this.chkeps(((CubicCurve2D)right).getY1(), -744.8125);
        this.chkeps(((CubicCurve2D)right).getCtrlX1(), 1011.75);
        this.chkeps(((CubicCurve2D)right).getCtrlY1(), -970.75);
        this.chkeps(((CubicCurve2D)right).getCtrlX2(), 1018.25);
        this.chkeps(((CubicCurve2D)right).getCtrlY2(), -936.25);
        this.chkeps(((CubicCurve2D)right).getX2(), 68.0);
        this.chkeps(((CubicCurve2D)right).getY2(), 96.0);
        CubicCurve2D.subdivide(left, null, left);
        this.chkeps(((CubicCurve2D)left).getX1(), 305.3046875);
        this.chkeps(((CubicCurve2D)left).getY1(), -302.7421875);
        this.chkeps(((CubicCurve2D)left).getCtrlX1(), 458.890625);
        this.chkeps(((CubicCurve2D)left).getCtrlY1(), -453.765625);
        this.chkeps(((CubicCurve2D)left).getCtrlX2(), 642.09375);
        this.chkeps(((CubicCurve2D)left).getCtrlY2(), -631.84375);
        this.chkeps(((CubicCurve2D)left).getX2(), 765.3125);
        this.chkeps(((CubicCurve2D)left).getY2(), -744.8125);
    }

    private void chkeps(double a, double b) {
        if (Math.abs(a - b) > 1.0E-6) {
            this.harness.check(a, b);
        } else {
            this.harness.check(true);
        }
    }
}

