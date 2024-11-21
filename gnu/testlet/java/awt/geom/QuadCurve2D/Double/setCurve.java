/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class setCurve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D.Double curve = new QuadCurve2D.Double(-1.0, -2.0, -3.0, -4.0, -5.0, -6.0);
        curve.setCurve(1.1, 2.2, 3.3, 4.4, 5.5, 6.6);
        harness.check(curve.x1, 1.1);
        harness.check(curve.y1, 2.2);
        harness.check(curve.ctrlx, 3.3);
        harness.check(curve.ctrly, 4.4);
        harness.check(curve.x2, 5.5);
        harness.check(curve.y2, 6.6);
    }
}

