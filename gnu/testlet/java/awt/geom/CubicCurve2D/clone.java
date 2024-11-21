/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D curve = (CubicCurve2D)new CubicCurve2D.Double(4.0, 3.0, 9.0, 1.0, 7.0, 8.0, 2.0, 6.0).clone();
        harness.check(curve instanceof CubicCurve2D.Double);
        harness.check(curve.getX1(), 4.0);
        harness.check(curve.getY1(), 3.0);
        harness.check(curve.getCtrlX1(), 9.0);
        harness.check(curve.getCtrlY1(), 1.0);
        harness.check(curve.getCtrlX2(), 7.0);
        harness.check(curve.getCtrlY2(), 8.0);
        harness.check(curve.getX2(), 2.0);
        harness.check(curve.getY2(), 6.0);
        curve = (CubicCurve2D)new CubicCurve2D.Float(-4.0f, 3.0f, -9.0f, 1.0f, 7.0f, -8.0f, -2.0f, -6.0f).clone();
        harness.check(curve instanceof CubicCurve2D.Float);
        harness.check(curve.getX1(), -4.0);
        harness.check(curve.getY1(), 3.0);
        harness.check(curve.getCtrlX1(), -9.0);
        harness.check(curve.getCtrlY1(), 1.0);
        harness.check(curve.getCtrlX2(), 7.0);
        harness.check(curve.getCtrlY2(), -8.0);
        harness.check(curve.getX2(), -2.0);
        harness.check(curve.getY2(), -6.0);
    }
}

