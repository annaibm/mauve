/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class setCurve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Double curve = new CubicCurve2D.Double(-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0);
        curve.setCurve(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8);
        harness.check(curve.x1, 1.1);
        harness.check(curve.y1, 2.2);
        harness.check(curve.ctrlx1, 3.3);
        harness.check(curve.ctrly1, 4.4);
        harness.check(curve.ctrlx2, 5.5);
        harness.check(curve.ctrly2, 6.6);
        harness.check(curve.x2, 7.7);
        harness.check(curve.y2, 8.8);
    }
}

