/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

public class setCurve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_array(harness);
        this.test_fourPoints(harness);
        this.test_PointArray(harness);
        this.test_CubicCurve2D(harness);
    }

    private void test_array(TestHarness harness) {
        harness.checkPoint("array");
        CubicCurve2D.Double curve = new CubicCurve2D.Double();
        curve.setCurve(new double[]{1.0, 2.0, 3.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0}, 3);
        harness.check(((CubicCurve2D)curve).getX1(), 11.0);
        harness.check(((CubicCurve2D)curve).getY1(), 12.0);
        harness.check(((CubicCurve2D)curve).getCtrlX1(), 13.0);
        harness.check(((CubicCurve2D)curve).getCtrlY1(), 14.0);
        harness.check(((CubicCurve2D)curve).getCtrlX2(), 15.0);
        harness.check(((CubicCurve2D)curve).getCtrlY2(), 16.0);
        harness.check(((CubicCurve2D)curve).getX2(), 17.0);
        harness.check(((CubicCurve2D)curve).getY2(), 18.0);
    }

    private void test_fourPoints(TestHarness harness) {
        harness.checkPoint("fourPoints");
        CubicCurve2D.Double curve = new CubicCurve2D.Double();
        curve.setCurve(new Point2D.Float(1.0f, 2.0f), new Point2D.Double(3.0, 4.0), new Point(5, 6), new Point2D.Float(7.0f, 8.0f));
        harness.check(((CubicCurve2D)curve).getX1(), 1.0);
        harness.check(((CubicCurve2D)curve).getY1(), 2.0);
        harness.check(((CubicCurve2D)curve).getCtrlX1(), 3.0);
        harness.check(((CubicCurve2D)curve).getCtrlY1(), 4.0);
        harness.check(((CubicCurve2D)curve).getCtrlX2(), 5.0);
        harness.check(((CubicCurve2D)curve).getCtrlY2(), 6.0);
        harness.check(((CubicCurve2D)curve).getX2(), 7.0);
        harness.check(((CubicCurve2D)curve).getY2(), 8.0);
    }

    private void test_PointArray(TestHarness harness) {
        Point2D[] pts = new Point2D[20];
        harness.checkPoint("PointArray");
        CubicCurve2D.Double curve = new CubicCurve2D.Double();
        pts[11] = new Point2D.Float(1.0f, 2.0f);
        pts[12] = new Point2D.Double(3.0, 4.0);
        pts[13] = new Point(5, 6);
        pts[14] = new Point(7, 8);
        curve.setCurve(pts, 11);
        harness.check(((CubicCurve2D)curve).getX1(), 1.0);
        harness.check(((CubicCurve2D)curve).getY1(), 2.0);
        harness.check(((CubicCurve2D)curve).getCtrlX1(), 3.0);
        harness.check(((CubicCurve2D)curve).getCtrlY1(), 4.0);
        harness.check(((CubicCurve2D)curve).getCtrlX2(), 5.0);
        harness.check(((CubicCurve2D)curve).getCtrlY2(), 6.0);
        harness.check(((CubicCurve2D)curve).getX2(), 7.0);
        harness.check(((CubicCurve2D)curve).getY2(), 8.0);
    }

    private void test_CubicCurve2D(TestHarness harness) {
        Point2D[] pts = new Point2D[20];
        harness.checkPoint("CubicCurve2D");
        CubicCurve2D curve = new CubicCurve2D.Float();
        curve.setCurve(new CubicCurve2D.Double(9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0));
        harness.check(curve.getX1(), 9.0);
        harness.check(curve.getY1(), 8.0);
        harness.check(curve.getCtrlX1(), 7.0);
        harness.check(curve.getCtrlY1(), 6.0);
        harness.check(curve.getCtrlX2(), 5.0);
        harness.check(curve.getCtrlY2(), 4.0);
        harness.check(curve.getX2(), 3.0);
        harness.check(curve.getY2(), 2.0);
        curve = new CubicCurve2D.Double();
        curve.setCurve(new CubicCurve2D.Float(90.0f, 80.0f, 70.0f, 60.0f, 50.0f, 40.0f, 30.0f, 20.0f));
        harness.check(curve.getX1(), 90.0);
        harness.check(curve.getY1(), 80.0);
        harness.check(curve.getCtrlX1(), 70.0);
        harness.check(curve.getCtrlY1(), 60.0);
        harness.check(curve.getCtrlX2(), 50.0);
        harness.check(curve.getCtrlY2(), 40.0);
        harness.check(curve.getX2(), 30.0);
        harness.check(curve.getY2(), 20.0);
    }
}

