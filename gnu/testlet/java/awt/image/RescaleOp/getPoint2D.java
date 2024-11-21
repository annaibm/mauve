/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.RescaleOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Point2D;
import java.awt.image.RescaleOp;

public class getPoint2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RescaleOp op = new RescaleOp(1.0f, 1.0f, null);
        Point2D.Double p = new Point2D.Double(1.0, 2.0);
        Point2D.Double pp = new Point2D.Double();
        Point2D p1 = op.getPoint2D(p, pp);
        harness.check(p1, p);
        harness.check(p1 == pp);
        harness.check(p1 != p);
        p1 = op.getPoint2D(p, null);
        harness.check(p1, p);
        harness.check(p1 != p);
        p1 = op.getPoint2D(p, p);
        harness.check(p1, p);
        harness.check(p1 == p);
    }
}

