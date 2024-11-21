/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r = new Rectangle2D.Double();
        r.add(1.0, 2.0);
        harness.check(((RectangularShape)r).getX(), 0.0);
        harness.check(((RectangularShape)r).getY(), 0.0);
        harness.check(((RectangularShape)r).getWidth(), 1.0);
        harness.check(((RectangularShape)r).getHeight(), 2.0);
        r = new Rectangle2D.Double();
        r.add(new Point2D.Double(1.0, 2.0));
        harness.check(((RectangularShape)r).getX(), 0.0);
        harness.check(((RectangularShape)r).getY(), 0.0);
        harness.check(((RectangularShape)r).getWidth(), 1.0);
        harness.check(((RectangularShape)r).getHeight(), 2.0);
        boolean pass = false;
        try {
            r.add((Point2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        r = new Rectangle2D.Double();
        r.add(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(((RectangularShape)r).getX(), 0.0);
        harness.check(((RectangularShape)r).getY(), 0.0);
        harness.check(((RectangularShape)r).getWidth(), 4.0);
        harness.check(((RectangularShape)r).getHeight(), 6.0);
        pass = false;
        try {
            r.add((Rectangle2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

