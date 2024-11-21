/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class getP1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D.Float curve = new QuadCurve2D.Float(-1.0f, -2.0f, -3.0f, -4.0f, -5.0f, -6.0f);
        harness.check(curve.getP1().getX(), -1.0);
        harness.check(curve.getP1().getY(), -2.0);
    }
}

