/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class getPoint2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Kernel k1 = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op = new ConvolveOp(k1, 1, null);
        Point p = new Point(7, 8);
        Point dest = new Point(0, 0);
        Point2D p1 = op.getPoint2D(p, dest);
        harness.check(p1, p);
        harness.check(p1 == dest);
        p1 = op.getPoint2D(p, null);
        harness.check(p1, p);
        harness.check(p1 != dest);
        boolean pass = false;
        try {
            op.getPoint2D(null, dest);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

