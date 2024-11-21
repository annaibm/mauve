/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class getCtrlPt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        QuadCurve2D.Double curve = new QuadCurve2D.Double(-1.0, -2.0, -3.0, -4.0, -5.0, -6.0);
        harness.check(curve.getCtrlPt().getX(), -3.0);
        harness.check(curve.getCtrlPt().getY(), -4.0);
    }
}

