/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.GeneralPath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;

public class getPathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_untransformed(harness);
        this.test_transformed(harness);
    }

    private void test_untransformed(TestHarness h) {
        float[] f = new float[6];
        double[] d = new double[6];
        h.checkPoint("untransformed");
        GeneralPath path = new GeneralPath(0);
        path.moveTo(10.0f, 11.0f);
        path.lineTo(20.0f, 21.0f);
        path.closePath();
        path.moveTo(30.0f, 31.0f);
        path.quadTo(40.0f, 41.0f, 42.0f, 43.0f);
        path.curveTo(50.0f, 51.0f, 52.0f, 53.0f, 54.0f, 55.0f);
        PathIterator pit = path.getPathIterator(null);
        h.check(pit.getWindingRule(), 0);
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 0);
        h.check(f[0], 10.0);
        h.check(f[1], 11.0);
        h.check(pit.currentSegment(d), 0);
        h.check(d[0], 10.0);
        h.check(d[1], 11.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 1);
        h.check(f[0], 20.0);
        h.check(f[1], 21.0);
        h.check(pit.currentSegment(d), 1);
        h.check(d[0], 20.0);
        h.check(d[1], 21.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 4);
        h.check(pit.currentSegment(d), 4);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 0);
        h.check(f[0], 30.0);
        h.check(f[1], 31.0);
        h.check(pit.currentSegment(d), 0);
        h.check(d[0], 30.0);
        h.check(d[1], 31.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 2);
        h.check(f[0], 40.0);
        h.check(f[1], 41.0);
        h.check(f[2], 42.0);
        h.check(f[3], 43.0);
        h.check(pit.currentSegment(d), 2);
        h.check(d[0], 40.0);
        h.check(d[1], 41.0);
        h.check(d[2], 42.0);
        h.check(d[3], 43.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 3);
        h.check(f[0], 50.0);
        h.check(f[1], 51.0);
        h.check(f[2], 52.0);
        h.check(f[3], 53.0);
        h.check(f[4], 54.0);
        h.check(f[5], 55.0);
        h.check(pit.currentSegment(d), 3);
        h.check(d[0], 50.0);
        h.check(d[1], 51.0);
        h.check(d[2], 52.0);
        h.check(d[3], 53.0);
        h.check(d[4], 54.0);
        h.check(d[5], 55.0);
        pit.next();
        h.check(pit.isDone());
    }

    private void test_transformed(TestHarness h) {
        float[] f = new float[6];
        double[] d = new double[6];
        h.checkPoint("transformed");
        GeneralPath path = new GeneralPath(1);
        path.moveTo(10.0f, 11.0f);
        path.lineTo(20.0f, 21.0f);
        path.closePath();
        path.moveTo(30.0f, 31.0f);
        path.quadTo(40.0f, 41.0f, 42.0f, 43.0f);
        path.curveTo(50.0f, 51.0f, 52.0f, 53.0f, 54.0f, 55.0f);
        AffineTransform tx = new AffineTransform();
        tx.translate(2.0, 3.0);
        tx.scale(10.0, 10.0);
        PathIterator pit = path.getPathIterator(tx);
        h.check(pit.getWindingRule(), 1);
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 0);
        h.check(f[0], 102.0);
        h.check(f[1], 113.0);
        h.check(pit.currentSegment(d), 0);
        h.check(d[0], 102.0);
        h.check(d[1], 113.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 1);
        h.check(f[0], 202.0);
        h.check(f[1], 213.0);
        h.check(pit.currentSegment(d), 1);
        h.check(d[0], 202.0);
        h.check(d[1], 213.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 4);
        h.check(pit.currentSegment(d), 4);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 0);
        h.check(f[0], 302.0);
        h.check(f[1], 313.0);
        h.check(pit.currentSegment(d), 0);
        h.check(d[0], 302.0);
        h.check(d[1], 313.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 2);
        h.check(f[0], 402.0);
        h.check(f[1], 413.0);
        h.check(f[2], 422.0);
        h.check(f[3], 433.0);
        h.check(pit.currentSegment(d), 2);
        h.check(d[0], 402.0);
        h.check(d[1], 413.0);
        h.check(d[2], 422.0);
        h.check(d[3], 433.0);
        pit.next();
        h.check(!pit.isDone());
        h.check(pit.currentSegment(f), 3);
        h.check(f[0], 502.0);
        h.check(f[1], 513.0);
        h.check(f[2], 522.0);
        h.check(f[3], 533.0);
        h.check(f[4], 542.0);
        h.check(f[5], 553.0);
        h.check(pit.currentSegment(d), 3);
        h.check(d[0], 502.0);
        h.check(d[1], 513.0);
        h.check(d[2], 522.0);
        h.check(d[3], 533.0);
        h.check(d[4], 542.0);
        h.check(d[5], 553.0);
        pit.next();
        h.check(pit.isDone());
    }
}

