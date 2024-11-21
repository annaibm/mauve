/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.GeneralPath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class getCurrentPoint
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GeneralPath path = new GeneralPath();
        Point2D.Float pt = new Point2D.Float();
        harness.check(path.getCurrentPoint() == null);
        path.moveTo(98.0f, 76.0f);
        ((Point2D)pt).setLocation(98.0, 76.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.moveTo(12.0f, 13.4f);
        ((Point2D)pt).setLocation(12.0, 13.4f);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.lineTo(-1.0f, -2.0f);
        ((Point2D)pt).setLocation(-1.0, -2.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.lineTo(-10.0f, -20.0f);
        ((Point2D)pt).setLocation(-10.0, -20.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.quadTo(1.0f, 2.0f, 3.0f, 4.0f);
        ((Point2D)pt).setLocation(3.0, 4.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.curveTo(5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f);
        ((Point2D)pt).setLocation(9.0, 10.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.closePath();
        ((Point2D)pt).setLocation(12.0, 13.4f);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.moveTo(50.0f, 51.0f);
        ((Point2D)pt).setLocation(50.0, 51.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.quadTo(52.0f, 53.0f, 54.0f, 55.0f);
        ((Point2D)pt).setLocation(54.0, 55.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.closePath();
        ((Point2D)pt).setLocation(50.0, 51.0);
        harness.check(pt.equals(path.getCurrentPoint()));
        path.reset();
        harness.check(path.getCurrentPoint() == null);
    }
}

