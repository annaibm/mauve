/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Rectangle2D;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Float curve = new CubicCurve2D.Float(1.0f, -2.0f, -3.0f, 4.0f, 5.0f, 7.0f, -8.0f, 9.0f);
        Rectangle2D bounds = curve.getBounds2D();
        harness.check(bounds instanceof Rectangle2D.Float);
        harness.check(bounds.getX(), -8.0);
        harness.check(bounds.getY(), -2.0);
        harness.check(bounds.getWidth(), 13.0);
        harness.check(bounds.getHeight(), 11.0);
    }
}

