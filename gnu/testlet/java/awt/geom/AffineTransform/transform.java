/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class transform
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int i;
        AffineTransform t1 = AffineTransform.getScaleInstance(2.0, 3.0);
        double[] d = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        double[] expected = new double[]{1.0, 2.0, 6.0, 12.0, 10.0, 18.0, 14.0, 24.0, 9.0, 10.0};
        t1.transform(d, 2, d, 2, 3);
        for (int i2 = 0; i2 < 10; ++i2) {
            harness.check(d[i2], expected[i2]);
        }
        d = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        float[] f = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f};
        float[] expectedf = new float[]{1.0f, 2.0f, 6.0f, 12.0f, 10.0f, 18.0f, 14.0f, 24.0f, 9.0f, 10.0f};
        t1.transform(d, 2, f, 2, 3);
        for (i = 0; i < 10; ++i) {
            harness.check(f[i], expectedf[i]);
        }
        f = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f};
        d = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        t1.transform(f, 2, d, 2, 3);
        for (i = 0; i < 10; ++i) {
            harness.check(d[i], expected[i]);
        }
        t1.transform(f, 2, f, 2, 3);
        for (i = 0; i < 10; ++i) {
            harness.check(f[i], expectedf[i]);
        }
        Point2D.Double p1 = new Point2D.Double(1.0, 2.0);
        Point2D p2 = t1.transform(p1, null);
        harness.check(p2.getX(), 2.0);
        harness.check(p2.getY(), 6.0);
        t1.transform(p1, p1);
        harness.check(((Point2D)p1).getX(), 2.0);
        harness.check(((Point2D)p1).getY(), 6.0);
        boolean pass = false;
        try {
            t1.transform(null, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

