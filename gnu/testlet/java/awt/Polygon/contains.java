/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Polygon;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Polygon 1");
        Polygon p = this.createTestPolygon1();
        harness.check(p.contains(0, 0));
        harness.check(!p.contains(0, 1));
        harness.check(p.contains(1, 0));
        harness.check(p.contains(1, 1));
        harness.check(!p.contains(1, 2));
        harness.check(!p.contains(2, 0));
        harness.check(!p.contains(2, 1));
        harness.checkPoint("Polygon 2");
        p = this.createTestPolygon2();
        harness.check(p.contains(0, 0));
        harness.check(!p.contains(0, 5));
        harness.check(!p.contains(5, 5));
        harness.check(!p.contains(5, 1));
        harness.check(p.contains(2, 1));
        harness.check(!p.contains(2, 3));
        harness.check(!p.contains(3, 3));
        harness.check(!p.contains(3, 2));
        harness.check(p.contains(4, 2));
        harness.check(p.contains(4, 4));
        harness.check(p.contains(1, 4));
        harness.check(!p.contains(1, 0));
        harness.check(!p.contains(-0.5, 2.5));
        harness.check(p.contains(0.5, 2.5));
        harness.check(!p.contains(1.5, 2.5));
        harness.check(p.contains(2.5, 2.5));
        harness.check(!p.contains(3.5, 2.5));
        harness.check(p.contains(4.5, 2.5));
        harness.check(!p.contains(5.5, 2.5));
        harness.checkPoint("Null argument checks");
        this.testNullArguments(harness);
    }

    private void testNullArguments(TestHarness harness) {
        boolean pass = false;
        Polygon p = new Polygon();
        try {
            p.contains((Point)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            p.contains((Point2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            p.contains((Rectangle2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private Polygon createTestPolygon1() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(1, 2);
        p.addPoint(2, 0);
        return p;
    }

    private Polygon createTestPolygon2() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(0, 5);
        p.addPoint(5, 5);
        p.addPoint(5, 1);
        p.addPoint(2, 1);
        p.addPoint(2, 3);
        p.addPoint(3, 3);
        p.addPoint(3, 2);
        p.addPoint(4, 2);
        p.addPoint(4, 4);
        p.addPoint(1, 4);
        p.addPoint(1, 0);
        return p;
    }
}

