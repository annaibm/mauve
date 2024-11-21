/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class intersect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r1 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        Rectangle2D.Double r2 = new Rectangle2D.Double(2.0, 1.0, 3.0, 4.0);
        Rectangle2D.Double r3 = new Rectangle2D.Double();
        Rectangle2D.intersect(r1, r2, r3);
        harness.check(((RectangularShape)r3).getX(), 2.0);
        harness.check(((RectangularShape)r3).getY(), 2.0);
        harness.check(((RectangularShape)r3).getWidth(), 2.0);
        harness.check(((RectangularShape)r3).getHeight(), 3.0);
        boolean pass = false;
        try {
            Rectangle2D.intersect(null, r2, r3);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Rectangle2D.intersect(r1, null, r3);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Rectangle2D.intersect(r1, r2, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

