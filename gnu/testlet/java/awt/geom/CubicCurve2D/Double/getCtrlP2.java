/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getCtrlP2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Double curve = new CubicCurve2D.Double(-1.0, -2.0, -3.141, 42.0, -5.0, -6.0, -77.0, 88.0);
        harness.check(curve.getCtrlP2().getX(), -5.0);
        harness.check(curve.getCtrlP2().getY(), -6.0);
    }
}

