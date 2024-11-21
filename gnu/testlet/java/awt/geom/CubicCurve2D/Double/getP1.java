/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getP1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Double curve = new CubicCurve2D.Double(-1.1E8, -2.2E7, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0);
        harness.check(curve.getP1().getX(), -1.1E8);
        harness.check(curve.getP1().getY(), -2.2E7);
    }
}

