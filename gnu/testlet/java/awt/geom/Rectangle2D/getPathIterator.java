/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.util.NoSuchElementException;

public class getPathIterator
implements Testlet {
    private static int M = 0;
    private static int L = 1;
    private static int C = 4;
    private int[] segs = new int[]{M, L, L, L, L, C};
    private double[] c1 = new double[]{10.0, 20.0, 40.0, 20.0, 40.0, 60.0, 10.0, 60.0, 10.0, 20.0};
    private double[] c2 = new double[]{75.0, 106.0, 105.0, 166.0, 225.0, 326.0, 195.0, 266.0, 75.0, 106.0};

    @Override
    public void test(TestHarness harness) {
        Rectangle ri = new Rectangle(10, 20, 30, 40);
        Rectangle2D.Float rf = new Rectangle2D.Float(10.0f, 20.0f, 30.0f, 40.0f);
        Rectangle2D.Double rd = new Rectangle2D.Double(10.0, 20.0, 30.0, 40.0);
        AffineTransform tx = new AffineTransform(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        harness.checkPoint("Rectangle.getPathIterator(null)");
        getPathIterator.checkPathIterator(harness, ri.getPathIterator(null), this.segs, this.c1);
        harness.checkPoint("Rectangle2D.Float.getPathIterator(null)");
        getPathIterator.checkPathIterator(harness, rf.getPathIterator(null), this.segs, this.c1);
        harness.checkPoint("Rectangle2D.Double.getPathIterator(null)");
        getPathIterator.checkPathIterator(harness, rd.getPathIterator(null), this.segs, this.c1);
        harness.checkPoint("Rectangle.getPathIterator(null, 0.4)");
        getPathIterator.checkPathIterator(harness, ri.getPathIterator(null, 0.4), this.segs, this.c1);
        harness.checkPoint("Rectangle2D.Float.getPathIterator(null, 0.4)");
        getPathIterator.checkPathIterator(harness, rf.getPathIterator(null, 0.4), this.segs, this.c1);
        harness.checkPoint("Rectangle2D.Float.getPathIterator(null, 0.4)");
        getPathIterator.checkPathIterator(harness, rd.getPathIterator(null, 0.4), this.segs, this.c1);
        harness.checkPoint("Rectangle.getPathIterator(tx)");
        getPathIterator.checkPathIterator(harness, ri.getPathIterator(tx), this.segs, this.c2);
        harness.checkPoint("Rectangle2D.Float.getPathIterator(tx)");
        getPathIterator.checkPathIterator(harness, rf.getPathIterator(tx), this.segs, this.c2);
        harness.checkPoint("Rectangle2D.Double.getPathIterator(tx)");
        getPathIterator.checkPathIterator(harness, rd.getPathIterator(tx), this.segs, this.c2);
        harness.checkPoint("Rectangle.getPathIterator(tx, 1)");
        getPathIterator.checkPathIterator(harness, ri.getPathIterator(tx, 1.0), this.segs, this.c2);
        harness.checkPoint("Rectangle2D.Float.getPathIterator(tx, 1)");
        getPathIterator.checkPathIterator(harness, rf.getPathIterator(tx, 1.0), this.segs, this.c2);
        harness.checkPoint("Rectangle2D.Double.getPathIterator(tx, 1)");
        getPathIterator.checkPathIterator(harness, rd.getPathIterator(tx, 1.0), this.segs, this.c2);
    }

    private static void checkPathIterator(TestHarness harness, PathIterator iter2, int[] segs, double[] d) {
        int i = 0;
        int j = 0;
        double[] dc = new double[2];
        float[] fc = new float[2];
        harness.check(iter2.getWindingRule(), 1);
        while (!iter2.isDone()) {
            int segD = iter2.currentSegment(dc);
            int segF = iter2.currentSegment(fc);
            harness.check(segD, segs[i]);
            harness.check(segF, segs[i]);
            switch (segD) {
                case 0: 
                case 1: {
                    harness.check(dc[0], d[j++]);
                    harness.check(dc[1], d[j++]);
                    harness.check(fc[0], (float)dc[0]);
                    harness.check(fc[1], (float)dc[1]);
                }
            }
            iter2.next();
            ++i;
        }
        harness.check(i, segs.length);
        boolean gotRightException = false;
        try {
            iter2.currentSegment(dc);
        }
        catch (NoSuchElementException ex) {
            gotRightException = true;
        }
        harness.check(gotRightException);
        iter2.next();
        harness.check(true);
    }
}

