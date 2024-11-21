/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Point;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.geom.Point2D;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Point p1 = new Point();
        Point p2 = new Point();
        harness.check(p1.equals(p2));
        p1 = new Point(1, 0);
        harness.check(!p1.equals(p2));
        p2 = new Point(1, 0);
        harness.check(p1.equals(p2));
        p1 = new Point(1, 2);
        harness.check(!p1.equals(p2));
        p2 = new Point(1, 2);
        harness.check(p1.equals(p2));
        harness.check(!p1.equals(null));
        Point2D.Double p3 = new Point2D.Double(1.0, 2.0);
        harness.check(p3.equals(p1));
    }
}

