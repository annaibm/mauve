/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class Double
implements Testlet {
    private TestHarness h;

    @Override
    public void test(TestHarness harness) {
        this.h = harness;
        this.testZeroArgs();
        this.testSixArgs();
    }

    public void testZeroArgs() {
        this.h.checkPoint("noArgs");
        QuadCurve2D.Double curve = new QuadCurve2D.Double();
        this.h.check(((QuadCurve2D)curve).getX1(), 0.0);
        this.h.check(((QuadCurve2D)curve).getY1(), 0.0);
        this.h.check(((QuadCurve2D)curve).getCtrlX(), 0.0);
        this.h.check(((QuadCurve2D)curve).getCtrlY(), 0.0);
        this.h.check(((QuadCurve2D)curve).getX2(), 0.0);
        this.h.check(((QuadCurve2D)curve).getY2(), 0.0);
    }

    public void testSixArgs() {
        this.h.checkPoint("sixArgs");
        QuadCurve2D.Double curve = new QuadCurve2D.Double(10.0, 200.0, 3000.0, 40000.0, 500000.0, 6000000.0);
        this.h.check(curve.getX1(), 10.0);
        this.h.check(curve.getY1(), 200.0);
        this.h.check(curve.getCtrlX(), 3000.0);
        this.h.check(curve.getCtrlY(), 40000.0);
        this.h.check(curve.getX2(), 500000.0);
        this.h.check(curve.getY2(), 6000000.0);
        this.h.check(curve.x1, 10.0);
        this.h.check(curve.y1, 200.0);
        this.h.check(curve.ctrlx, 3000.0);
        this.h.check(curve.ctrly, 40000.0);
        this.h.check(curve.x2, 500000.0);
        this.h.check(curve.y2, 6000000.0);
    }
}

