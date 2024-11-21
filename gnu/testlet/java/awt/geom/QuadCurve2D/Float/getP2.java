/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class getP2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D.Float curve = new QuadCurve2D.Float(-1.0f, -2.0f, -3.0f, -4.0f, -5.0f, -6.0f);
        harness.check(curve.getP2().getX(), -5.0);
        harness.check(curve.getP2().getY(), -6.0);
    }
}

