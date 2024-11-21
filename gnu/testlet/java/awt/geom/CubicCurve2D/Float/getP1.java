/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getP1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Float curve = new CubicCurve2D.Float(-1.2E8f, -2.3E7f, -3.0f, -4.0f, -5.0f, -6.0f, -7.0f, -8.0f);
        harness.check(curve.getP1().getX(), -1.2E8);
        harness.check(curve.getP1().getY(), -2.3E7);
    }
}

