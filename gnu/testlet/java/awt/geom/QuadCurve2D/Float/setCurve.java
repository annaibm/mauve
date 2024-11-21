/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class setCurve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D.Float curve = new QuadCurve2D.Float(-1.0f, -2.0f, -3.0f, -4.0f, -5.0f, -6.0f);
        curve.setCurve(1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f);
        harness.check(curve.x1, 1.1f);
        harness.check(curve.y1, 2.2f);
        harness.check(curve.ctrlx, 3.3f);
        harness.check(curve.ctrly, 4.4f);
        harness.check(curve.x2, 5.5);
        harness.check(curve.y2, 6.6f);
    }
}

