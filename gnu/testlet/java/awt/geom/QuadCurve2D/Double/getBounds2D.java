/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D.Double curve = new QuadCurve2D.Double(1.0, -2.0, -3.0, 4.0, 5.0, 7.0);
        Rectangle2D bounds = curve.getBounds2D();
        harness.check(bounds instanceof Rectangle2D.Double);
        harness.check(bounds.getX(), -3.0);
        harness.check(bounds.getY(), -2.0);
        harness.check(bounds.getWidth(), 8.0);
        harness.check(bounds.getHeight(), 9.0);
    }
}

