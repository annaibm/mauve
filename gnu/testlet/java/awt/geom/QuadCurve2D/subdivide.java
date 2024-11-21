/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;
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
        double[] src = new double[]{7.0, 7.0, 1.5, 2.0, 3.0, 4.0, -5.0, 6.0};
        double[] left = new double[11];
        QuadCurve2D.subdivide(src, 2, left, 1, left, 5);
        this.harness.check(Arrays.equals(left, new double[]{0.0, 1.5, 2.0, 2.25, 3.0, 0.625, 4.0, -1.0, 5.0, -5.0, 6.0}));
        try {
            QuadCurve2D.subdivide(src, 0, null, 0, null, 0);
            this.harness.check(true);
        }
        catch (Exception ex) {
            this.harness.check(false);
        }
        src = new double[6];
        left = new double[6];
        double[] right = new double[6];
        QuadCurve2D.subdivide(src, 0, left, 0, right, 0);
        this.harness.check(Arrays.equals(left, new double[6]));
        this.harness.check(Arrays.equals(left, right));
    }

    private void test_curve2() {
        this.harness.checkPoint("curve2");
        QuadCurve2D.Double src = new QuadCurve2D.Double(42.0, 24.0, 123.0, 321.0, -78011.0, -11087.0);
        QuadCurve2D.Double left = new QuadCurve2D.Double();
        QuadCurve2D.Float right = new QuadCurve2D.Float();
        src.subdivide(left, right);
        this.chkeps(((QuadCurve2D)left).getX1(), 42.0);
        this.chkeps(((QuadCurve2D)left).getY1(), 24.0);
        this.chkeps(((QuadCurve2D)left).getCtrlX(), 82.5);
        this.chkeps(((QuadCurve2D)left).getCtrlY(), 172.5);
        this.chkeps(((QuadCurve2D)left).getX2(), -19430.75);
        this.chkeps(((QuadCurve2D)left).getY2(), -2605.25);
        this.chkeps(((QuadCurve2D)right).getX1(), -19430.75);
        this.chkeps(((QuadCurve2D)right).getY1(), -2605.25);
        this.chkeps(((QuadCurve2D)right).getCtrlX(), -38944.0);
        this.chkeps(((QuadCurve2D)right).getCtrlY(), -5383.0);
        this.chkeps(((QuadCurve2D)right).getX2(), -78011.0);
        this.chkeps(((QuadCurve2D)right).getY2(), -11087.0);
    }

    private void test_curve3() {
        this.harness.checkPoint("curve3");
        QuadCurve2D.Double src = new QuadCurve2D.Double(23.0, -23.0, 42.0, -42.0, 1968.5, -1968.5);
        QuadCurve2D.Float left = new QuadCurve2D.Float();
        QuadCurve2D.Float right = new QuadCurve2D.Float();
        QuadCurve2D.subdivide(src, left, right);
        this.chkeps(((QuadCurve2D)left).getX1(), 23.0);
        this.chkeps(((QuadCurve2D)left).getY1(), -23.0);
        this.chkeps(((QuadCurve2D)left).getCtrlX(), 32.5);
        this.chkeps(((QuadCurve2D)left).getCtrlY(), -32.5);
        this.chkeps(((QuadCurve2D)left).getX2(), 518.875);
        this.chkeps(((QuadCurve2D)left).getY2(), -518.875);
        this.chkeps(((QuadCurve2D)right).getX1(), 518.875);
        this.chkeps(((QuadCurve2D)right).getY1(), -518.875);
        this.chkeps(((QuadCurve2D)right).getCtrlX(), 1005.25);
        this.chkeps(((QuadCurve2D)right).getCtrlY(), -1005.25);
        this.chkeps(((QuadCurve2D)right).getX2(), 1968.5);
        this.chkeps(((QuadCurve2D)right).getY2(), -1968.5);
        QuadCurve2D.subdivide(left, null, left);
        this.chkeps(((QuadCurve2D)left).getX1(), 151.71875);
        this.chkeps(((QuadCurve2D)left).getY1(), -151.71875);
        this.chkeps(((QuadCurve2D)left).getCtrlX(), 275.6875);
        this.chkeps(((QuadCurve2D)left).getCtrlY(), -275.6875);
        this.chkeps(((QuadCurve2D)left).getX2(), 518.875);
        this.chkeps(((QuadCurve2D)left).getY2(), -518.875);
    }

    private void chkeps(double a, double b) {
        if (Math.abs(a - b) > 1.0E-6) {
            this.harness.check(a, b);
        } else {
            this.harness.check(true);
        }
    }
}

