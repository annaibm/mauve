/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

public class setCurve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_array(harness);
        this.test_threePoints(harness);
        this.test_PointArray(harness);
        this.test_QuadCurve2D(harness);
    }

    private void test_array(TestHarness harness) {
        harness.checkPoint("array");
        QuadCurve2D.Double curve = new QuadCurve2D.Double();
        curve.setCurve(new double[]{1.0, 2.0, 3.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0}, 3);
        harness.check(((QuadCurve2D)curve).getX1(), 11.0);
        harness.check(((QuadCurve2D)curve).getY1(), 12.0);
        harness.check(((QuadCurve2D)curve).getCtrlX(), 13.0);
        harness.check(((QuadCurve2D)curve).getCtrlY(), 14.0);
        harness.check(((QuadCurve2D)curve).getX2(), 15.0);
        harness.check(((QuadCurve2D)curve).getY2(), 16.0);
    }

    private void test_threePoints(TestHarness harness) {
        harness.checkPoint("threePoints");
        QuadCurve2D.Double curve = new QuadCurve2D.Double();
        curve.setCurve(new Point2D.Float(1.0f, 2.0f), new Point2D.Double(3.0, 4.0), new Point(5, 6));
        harness.check(((QuadCurve2D)curve).getX1(), 1.0);
        harness.check(((QuadCurve2D)curve).getY1(), 2.0);
        harness.check(((QuadCurve2D)curve).getCtrlX(), 3.0);
        harness.check(((QuadCurve2D)curve).getCtrlY(), 4.0);
        harness.check(((QuadCurve2D)curve).getX2(), 5.0);
        harness.check(((QuadCurve2D)curve).getY2(), 6.0);
    }

    private void test_PointArray(TestHarness harness) {
        Point2D[] pts = new Point2D[20];
        harness.checkPoint("PointArray");
        QuadCurve2D.Double curve = new QuadCurve2D.Double();
        pts[11] = new Point2D.Float(1.0f, 2.0f);
        pts[12] = new Point2D.Double(3.0, 4.0);
        pts[13] = new Point(5, 6);
        curve.setCurve(pts, 11);
        harness.check(((QuadCurve2D)curve).getX1(), 1.0);
        harness.check(((QuadCurve2D)curve).getY1(), 2.0);
        harness.check(((QuadCurve2D)curve).getCtrlX(), 3.0);
        harness.check(((QuadCurve2D)curve).getCtrlY(), 4.0);
        harness.check(((QuadCurve2D)curve).getX2(), 5.0);
        harness.check(((QuadCurve2D)curve).getY2(), 6.0);
    }

    private void test_QuadCurve2D(TestHarness harness) {
        Point2D[] pts = new Point2D[20];
        harness.checkPoint("QuadCurve2D");
        QuadCurve2D curve = new QuadCurve2D.Float();
        curve.setCurve(new QuadCurve2D.Double(9.0, 8.0, 7.0, 6.0, 5.0, 4.0));
        harness.check(curve.getX1(), 9.0);
        harness.check(curve.getY1(), 8.0);
        harness.check(curve.getCtrlX(), 7.0);
        harness.check(curve.getCtrlY(), 6.0);
        harness.check(curve.getX2(), 5.0);
        harness.check(curve.getY2(), 4.0);
        curve = new QuadCurve2D.Double();
        curve.setCurve(new QuadCurve2D.Float(90.0f, 80.0f, 70.0f, 60.0f, 50.0f, 40.0f));
        harness.check(curve.getX1(), 90.0);
        harness.check(curve.getY1(), 80.0);
        harness.check(curve.getCtrlX(), 70.0);
        harness.check(curve.getCtrlY(), 60.0);
        harness.check(curve.getX2(), 50.0);
        harness.check(curve.getY2(), 40.0);
    }
}

