/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class getCtrlP1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CubicCurve2D.Float curve = new CubicCurve2D.Float(-1.0f, -2.0f, -3.141f, 42.0f, -5.0f, -6.0f, -77.0f, 88.0f);
        harness.check(curve.getCtrlP1().getX(), -3.141f);
        harness.check(curve.getCtrlP1().getY(), 42.0);
    }
}

