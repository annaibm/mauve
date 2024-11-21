/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class Float
implements Testlet {
    private TestHarness h;

    @Override
    public void test(TestHarness harness) {
        this.h = harness;
        this.testZeroArgs();
        this.testEightArgs();
    }

    public void testZeroArgs() {
        this.h.checkPoint("noArgs");
        CubicCurve2D.Float curve = new CubicCurve2D.Float();
        this.h.check(((CubicCurve2D)curve).getX1(), 0.0);
        this.h.check(((CubicCurve2D)curve).getY1(), 0.0);
        this.h.check(((CubicCurve2D)curve).getCtrlX1(), 0.0);
        this.h.check(((CubicCurve2D)curve).getCtrlY1(), 0.0);
        this.h.check(((CubicCurve2D)curve).getCtrlX2(), 0.0);
        this.h.check(((CubicCurve2D)curve).getCtrlY2(), 0.0);
        this.h.check(((CubicCurve2D)curve).getX2(), 0.0);
        this.h.check(((CubicCurve2D)curve).getY2(), 0.0);
    }

    public void testEightArgs() {
        this.h.checkPoint("eightArgs");
        CubicCurve2D.Float curve = new CubicCurve2D.Float(10.0f, 200.0f, 3000.0f, 40000.0f, 500000.0f, 6000000.0f, 7.0E7f, 8.0E8f);
        this.h.check(curve.getX1(), 10.0);
        this.h.check(curve.getY1(), 200.0);
        this.h.check(curve.getCtrlX1(), 3000.0);
        this.h.check(curve.getCtrlY1(), 40000.0);
        this.h.check(curve.getCtrlX2(), 500000.0);
        this.h.check(curve.getCtrlY2(), 6000000.0);
        this.h.check(curve.getX2(), 7.0E7);
        this.h.check(curve.getY2(), 8.0E8);
        this.h.check(curve.x1, 10.0);
        this.h.check(curve.y1, 200.0);
        this.h.check(curve.ctrlx1, 3000.0);
        this.h.check(curve.ctrly1, 40000.0);
        this.h.check(curve.ctrlx2, 500000.0);
        this.h.check(curve.ctrly2, 6000000.0);
        this.h.check(curve.x2, 7.0E7);
        this.h.check(curve.y2, 8.0E8);
    }
}

