/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class setCurve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Float curve = new CubicCurve2D.Float(-1.0f, -2.0f, -3.0f, -4.0f, -5.0f, -6.0f, -7.0f, -8.0f);
        curve.setCurve(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8);
        harness.check(curve.x1, 1.1f);
        harness.check(curve.y1, 2.2f);
        harness.check(curve.ctrlx1, 3.3f);
        harness.check(curve.ctrly1, 4.4f);
        harness.check(curve.ctrlx2, 5.5);
        harness.check(curve.ctrly2, 6.6f);
        harness.check(curve.x2, 7.7f);
        harness.check(curve.y2, 8.8f);
    }
}

