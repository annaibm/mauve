/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

public class inverseTransform
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = AffineTransform.getScaleInstance(0.5, 0.25);
        double[] v = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        double[] expected = new double[]{1.0, 2.0, 6.0, 16.0, 10.0, 24.0, 14.0, 32.0, 9.0, 10.0};
        try {
            t1.inverseTransform(v, 2, v, 2, 3);
            for (int i = 0; i < 10; ++i) {
                harness.check(v[i], expected[i]);
            }
        }
        catch (NoninvertibleTransformException e) {
            harness.check(false);
        }
        Point2D.Double p1 = new Point2D.Double(1.0, 2.0);
        try {
            Point2D p2 = t1.inverseTransform(p1, null);
            harness.check(p2.getX(), 2.0);
            harness.check(p2.getY(), 8.0);
            t1.inverseTransform(p1, p1);
            harness.check(((Point2D)p1).getX(), 2.0);
            harness.check(((Point2D)p1).getY(), 8.0);
        }
        catch (NoninvertibleTransformException e) {
            harness.check(false);
        }
        boolean pass = false;
        try {
            t1.inverseTransform(null, null);
        }
        catch (NoninvertibleTransformException e1) {
            pass = false;
        }
        catch (NullPointerException e2) {
            pass = true;
        }
        harness.check(pass);
    }
}

