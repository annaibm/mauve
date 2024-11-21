/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;

public class getPathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_untransformed(harness);
        this.test_transformed(harness);
    }

    public void test_untransformed(TestHarness harness) {
        double[] c = new double[6];
        harness.checkPoint("untransformed");
        CubicCurve2D.Double curve = new CubicCurve2D.Double(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        PathIterator pit = curve.getPathIterator(null);
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 0);
        harness.check(c[0], 1.0);
        harness.check(c[1], 2.0);
        pit.next();
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 3);
        harness.check(c[0], 3.0);
        harness.check(c[1], 4.0);
        harness.check(c[2], 5.0);
        harness.check(c[3], 6.0);
        harness.check(c[4], 7.0);
        harness.check(c[5], 8.0);
        pit.next();
        harness.check(pit.isDone());
        harness.check(pit.getWindingRule(), 1);
    }

    public void test_transformed(TestHarness harness) {
        double[] c = new double[6];
        harness.checkPoint("transformed");
        AffineTransform tx = new AffineTransform();
        tx.scale(2.0, 3.0);
        tx.translate(1.0, -1.0);
        CubicCurve2D.Double curve = new CubicCurve2D.Double(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        PathIterator pit = curve.getPathIterator(tx);
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 0);
        harness.check(c[0], 4.0);
        harness.check(c[1], 3.0);
        pit.next();
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 3);
        harness.check(c[0], 8.0);
        harness.check(c[1], 9.0);
        harness.check(c[2], 12.0);
        harness.check(c[3], 15.0);
        harness.check(c[4], 16.0);
        harness.check(c[5], 21.0);
        pit.next();
        harness.check(pit.isDone());
        harness.check(pit.getWindingRule(), 1);
    }
}

