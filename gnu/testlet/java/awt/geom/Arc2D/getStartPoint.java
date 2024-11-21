/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;

public class getStartPoint
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 2);
        Point2D p = arc.getStartPoint();
        harness.check(p.getX(), 1.0);
        harness.check(p.getY(), 0.0);
    }
}

