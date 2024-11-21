/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getP2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Float curve = new CubicCurve2D.Float(-1.0f, -2.0f, -3.0f, 42.0f, -5.0f, -6.0f, -77.7f, 88.8f);
        harness.check(curve.getP2().getX(), -77.7f);
        harness.check(curve.getP2().getY(), 88.8f);
    }
}

