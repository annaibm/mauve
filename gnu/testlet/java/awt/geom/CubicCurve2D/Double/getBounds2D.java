/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Rectangle2D;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Double curve = new CubicCurve2D.Double(11.0, -22.0, -33.0, 44.0, -55.0, 75.0, -85.0, 91.0);
        Rectangle2D bounds = curve.getBounds2D();
        harness.check(bounds instanceof Rectangle2D.Double);
        harness.check(bounds.getX(), -85.0);
        harness.check(bounds.getY(), -22.0);
        harness.check(bounds.getWidth(), 96.0);
        harness.check(bounds.getHeight(), 113.0);
    }
}

