/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D curve = (QuadCurve2D)new QuadCurve2D.Double(4.0, 3.0, 9.0, 1.0, 7.0, 8.0).clone();
        harness.check(curve instanceof QuadCurve2D.Double);
        harness.check(curve.getX1(), 4.0);
        harness.check(curve.getY1(), 3.0);
        harness.check(curve.getCtrlX(), 9.0);
        harness.check(curve.getCtrlY(), 1.0);
        harness.check(curve.getX2(), 7.0);
        harness.check(curve.getY2(), 8.0);
        curve = (QuadCurve2D)new QuadCurve2D.Float(-4.0f, 3.0f, -9.0f, 1.0f, 7.0f, -8.0f).clone();
        harness.check(curve instanceof QuadCurve2D.Float);
        harness.check(curve.getX1(), -4.0);
        harness.check(curve.getY1(), 3.0);
        harness.check(curve.getCtrlX(), -9.0);
        harness.check(curve.getCtrlY(), 1.0);
        harness.check(curve.getX2(), 7.0);
        harness.check(curve.getY2(), -8.0);
    }
}

