/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.FlatteningPathIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.QuadCurve2D;

public class currentSegment
implements Testlet {
    private static final float EPSILON_F = 1.0E-6f;
    private static final double EPSILON = 1.0E-6;

    @Override
    public void test(TestHarness h) {
        this.test_emptyPath(h);
        this.test_quadCurve(h);
        this.test_cubicCurve(h);
    }

    private void test_emptyPath(TestHarness h) {
        h.checkPoint("emptyPath");
        GeneralPath path = new GeneralPath();
        FlatteningPathIterator fpi = new FlatteningPathIterator(path.getPathIterator(null), 1.0E-4, 0);
        h.check(fpi.isDone());
    }

    public void test_quadCurve(TestHarness h) {
        h.checkPoint("quadCurve-A");
        this.test_quadCurve(h, 0.0, 0, 10.0, -10.0, 20.0, -1234.0, 400.0, 800.0, new double[]{0.0, 10.0, -10.0, 1.0, 400.0, 800.0});
        h.checkPoint("quadCurve-B");
        this.test_quadCurve(h, 0.0, 1, 10.0, -10.0, 20.0, -1234.0, 400.0, 800.0, new double[]{0.0, 10.0, -10.0, 1.0, 112.5, -419.5, 1.0, 400.0, 800.0});
        h.checkPoint("quadCurve-C");
        this.test_quadCurve(h, 0.0, 2, 0.0, 0.0, 1.0, -1.0, 2.0, -2.0, new double[]{0.0, 0.0, 0.0, 1.0, 0.5, -0.5, 1.0, 1.0, -1.0, 1.0, 1.5, -1.5, 1.0, 2.0, -2.0});
        h.checkPoint("quadCurve-D");
        this.test_quadCurve(h, 0.1, 2, 0.0, 0.0, 1.0, -1.0, 2.0, -2.0, new double[]{0.0, 0.0, 0.0, 1.0, 2.0, -2.0});
        h.checkPoint("quadCurve-E");
        this.test_quadCurve(h, 1.0, 8, 10.0, -20.0, 3.0, 4.0, 5.0, 6.0, new double[]{0.0, 10.0, -20.0, 1.0, 5.25, -1.5, 1.0, 4.5625, 3.625, 1.0, 5.0, 6.0});
        h.checkPoint("quadCurve-F");
        this.test_quadCurve(h, 4.0, 8, 10.0, -20.0, 3.0, 4.0, 5.0, 6.0, new double[]{0.0, 10.0, -20.0, 1.0, 5.0, 6.0});
        h.checkPoint("quadCurve-G");
        this.test_quadCurve(h, 4.0, 8, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, new double[]{0.0, 2.3, 2.3, 1.0, 2.3, 2.3});
    }

    private void test_quadCurve(TestHarness h, double flatness, int level, double x1, double y1, double cx, double cy, double x2, double y2, double[] data) {
        QuadCurve2D.Double curve = new QuadCurve2D.Double(x1, y1, cx, cy, x2, y2);
        FlatteningPathIterator fpi = new FlatteningPathIterator(curve.getPathIterator(null), flatness, level);
        if (data == null) {
            this.dump(fpi);
        } else {
            this.checkSegments(h, fpi, data);
        }
    }

    public void test_cubicCurve(TestHarness h) {
        h.checkPoint("cubicCurve-A");
        this.test_cubicCurve(h, 0.0, 0, 10.0, -10.0, 20.0, -1234.0, 400.0, 800.0, 0.0, 1.0, new double[]{0.0, 10.0, -10.0, 1.0, 0.0, 1.0});
        h.checkPoint("cubicCurve-B");
        this.test_cubicCurve(h, 0.0, 1, 10.0, -10.0, 20.0, -1234.0, 400.0, 800.0, 120.0, 10.0, new double[]{0.0, 10.0, -10.0, 1.0, 173.75, -162.75, 1.0, 120.0, 10.0});
        h.checkPoint("cubicCurve-C");
        this.test_cubicCurve(h, 0.0, 2, 0.0, 0.0, 1.0, -1.0, 2.0, -2.0, 3.0, -3.0, new double[]{0.0, 0.0, 0.0, 1.0, 0.75, -0.75, 1.0, 1.5, -1.5, 1.0, 2.25, -2.25, 1.0, 3.0, -3.0});
        h.checkPoint("cubicCurve-D");
        this.test_cubicCurve(h, 0.1, 2, 0.0, 0.0, 1.0, -1.0, 2.0, -2.0, 3.0, -3.0, new double[]{0.0, 0.0, 0.0, 1.0, 3.0, -3.0});
        h.checkPoint("cubicCurve-E");
        this.test_cubicCurve(h, 5.0, 8, 10.0, -20.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new double[]{0.0, 10.0, -20.0, 1.0, 7.0, 8.0});
        h.checkPoint("cubicCurve-F");
        this.test_cubicCurve(h, 3.0, 8, 10.0, -20.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new double[]{0.0, 10.0, -20.0, 1.0, 5.125, 2.25, 1.0, 7.0, 8.0});
        h.checkPoint("cubicCurve-G");
        this.test_cubicCurve(h, 1.0, 8, 10.0, -20.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new double[]{0.0, 10.0, -20.0, 1.0, 5.125, 2.25, 1.0, 5.640625, 6.15625, 1.0, 7.0, 8.0});
        h.checkPoint("cubicCurve-H");
        this.test_cubicCurve(h, 0.8, 8, 10.0, -20.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new double[]{0.0, 10.0, -20.0, 1.0, 6.296875, -5.78125, 1.0, 5.125, 2.25, 1.0, 5.640625, 6.15625, 1.0, 7.0, 8.0});
        h.checkPoint("cubicCurve-I");
        this.test_cubicCurve(h, 4.0, 8, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, new double[]{0.0, 2.3, 2.3, 1.0, 2.3, 2.3});
    }

    private void test_cubicCurve(TestHarness h, double flatness, int level, double x1, double y1, double cx1, double cy1, double cx2, double cy2, double x2, double y2, double[] data) {
        CubicCurve2D.Double curve = new CubicCurve2D.Double(x1, y1, cx1, cy1, cx2, cy2, x2, y2);
        FlatteningPathIterator fpi = new FlatteningPathIterator(curve.getPathIterator(null), flatness, level);
        if (data == null) {
            this.dump(fpi);
        } else {
            this.checkSegments(h, fpi, data);
        }
    }

    private void test_generalPath(TestHarness h) {
        h.checkPoint("generalPath");
        GeneralPath path = new GeneralPath();
        path.moveTo(1.1f, 1.2f);
        path.lineTo(2.1f, 2.2f);
        path.quadTo(3.1f, 3.2f, 4.1f, 4.2f);
        path.closePath();
        path.moveTo(5.1f, 5.2f);
        path.curveTo(6.1f, 6.2f, 7.1f, 7.2f, 8.1f, 8.2f);
    }

    private void checkSegments(TestHarness h, PathIterator pit, double[] pt) {
        for (int i = 0; i < pt.length / 3; ++i) {
            this.checkSegment(h, pit, i, pt);
            pit.next();
        }
        h.check(pit.isDone());
    }

    private void checkSegment(TestHarness h, PathIterator pit, int seg, double[] pt) {
        double[] d = new double[6];
        float[] f = new float[6];
        if (pit.isDone()) {
            h.check(false);
            h.debug("path iterator is prematurely done");
            return;
        }
        int expectedSegType = (int)pt[3 * seg];
        int segType = pit.currentSegment(d);
        if (segType != expectedSegType) {
            h.debug("segment type mismatch (double[]): got " + currentSegment.getSegmentTypeName(segType) + ", expected " + currentSegment.getSegmentTypeName(expectedSegType));
            return;
        }
        segType = pit.currentSegment(f);
        if (segType != (int)pt[3 * seg]) {
            h.check(segType, (int)pt[3 * seg]);
            h.debug("segment type mismatch (float[])");
            return;
        }
        if (segType == 4) {
            h.check(true);
            return;
        }
        double x = pt[3 * seg + 1];
        double y = pt[3 * seg + 2];
        if (Math.abs(d[0] - x) > 1.0E-6 || Math.abs(d[1] - y) > 1.0E-6) {
            this.chkpt(h, d, 0, x, y);
            return;
        }
        this.chkpt(h, f, 0, (float)x, (float)y);
    }

    private void chkpt(TestHarness h, float[] f, int off, float x, float y) {
        if (Math.abs(f[off] - x) > 1.0E-6f || Math.abs(f[off + 1] - y) > 1.0E-6f) {
            h.check(false);
            h.debug("got (" + f[off] + ", " + f[off + 1] + ") but expected (" + x + ", " + y + ")");
        } else {
            h.check(true);
        }
    }

    private void chkpt(TestHarness h, double[] f, int off, double x, double y) {
        if (Math.abs(f[off] - x) > 1.0E-6 || Math.abs(f[off + 1] - y) > 1.0E-6) {
            h.check(false);
            h.debug("got (" + f[off] + ", " + f[off + 1] + ") but expected (" + x + ", " + y + ")");
        } else {
            h.check(true);
        }
    }

    private static String getSegmentTypeName(int seg) {
        switch (seg) {
            case 0: {
                return "PathIterator.SEG_MOVETO";
            }
            case 1: {
                return "PathIterator.SEG_LINETO";
            }
            case 2: {
                return "PathIterator.SEG_QUADTO";
            }
            case 3: {
                return "PathIterator.SEG_CUBICTO";
            }
            case 4: {
                return "PathIterator.SEG_CLOSE";
            }
        }
        throw new IllegalArgumentException();
    }

    private void dump(PathIterator p) {
        double[] d = new double[6];
        int i = 1;
        System.out.println("    {");
        while (!p.isDone()) {
            int seg = p.currentSegment(d);
            System.out.print("      /* Check " + i++ + " */ ");
            System.out.print(currentSegment.getSegmentTypeName(seg));
            System.out.println(", " + d[0] + ", " + d[1] + ",");
            p.next();
        }
        System.out.println("      /* Check " + i + ": PathIterator.isDone() */");
        System.out.println("    });");
    }
}

