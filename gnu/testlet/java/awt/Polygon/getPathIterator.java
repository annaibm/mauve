/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Polygon;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;

public class getPathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(AffineTransform)");
        Polygon p = new Polygon(new int[]{0, 1, 1, 0}, new int[]{0, 0, 1, 1}, 4);
        PathIterator pi = p.getPathIterator(null);
        harness.check(pi.getWindingRule(), 0);
        double[] coords = new double[6];
        int t = pi.currentSegment(coords);
        harness.check(t, 0);
        harness.check(coords[0], 0.0);
        harness.check(coords[1], 0.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 1.0);
        harness.check(coords[1], 0.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 1.0);
        harness.check(coords[1], 1.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 0.0);
        harness.check(coords[1], 1.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 4);
        harness.check(pi.isDone(), false);
        pi.next();
        harness.check(pi.isDone(), true);
        AffineTransform trans = AffineTransform.getTranslateInstance(10.0, 11.0);
        pi = p.getPathIterator(trans);
        harness.check(pi.getWindingRule(), 0);
        coords = new double[6];
        t = pi.currentSegment(coords);
        harness.check(t, 0);
        harness.check(coords[0], 10.0);
        harness.check(coords[1], 11.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 11.0);
        harness.check(coords[1], 11.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 11.0);
        harness.check(coords[1], 12.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 10.0);
        harness.check(coords[1], 12.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 4);
        harness.check(pi.isDone(), false);
        pi.next();
        harness.check(pi.isDone(), true);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(AffineTransform, double)");
        Polygon p = new Polygon(new int[]{0, 1, 1, 0}, new int[]{0, 0, 1, 1}, 4);
        PathIterator pi = p.getPathIterator(null, 1.0);
        harness.check(pi.getWindingRule(), 0);
        double[] coords = new double[6];
        int t = pi.currentSegment(coords);
        harness.check(t, 0);
        harness.check(coords[0], 0.0);
        harness.check(coords[1], 0.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 1.0);
        harness.check(coords[1], 0.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 1.0);
        harness.check(coords[1], 1.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 0.0);
        harness.check(coords[1], 1.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 4);
        harness.check(pi.isDone(), false);
        pi.next();
        harness.check(pi.isDone(), true);
        AffineTransform trans = AffineTransform.getTranslateInstance(10.0, 11.0);
        pi = p.getPathIterator(trans, 1.0);
        harness.check(pi.getWindingRule(), 0);
        coords = new double[6];
        t = pi.currentSegment(coords);
        harness.check(t, 0);
        harness.check(coords[0], 10.0);
        harness.check(coords[1], 11.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 11.0);
        harness.check(coords[1], 11.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 11.0);
        harness.check(coords[1], 12.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 1);
        harness.check(coords[0], 10.0);
        harness.check(coords[1], 12.0);
        harness.check(pi.isDone(), false);
        pi.next();
        t = pi.currentSegment(coords);
        harness.check(t, 4);
        harness.check(pi.isDone(), false);
        pi.next();
        harness.check(pi.isDone(), true);
    }
}

