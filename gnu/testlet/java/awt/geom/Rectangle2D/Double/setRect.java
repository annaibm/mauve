/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class setRect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r1 = new Rectangle2D.Double();
        ((Rectangle2D)r1).setRect(1.0, 2.0, 3.0, 4.0);
        harness.check(((RectangularShape)r1).getX(), 1.0);
        harness.check(((RectangularShape)r1).getY(), 2.0);
        harness.check(((RectangularShape)r1).getWidth(), 3.0);
        harness.check(((RectangularShape)r1).getHeight(), 4.0);
        ((Rectangle2D)r1).setRect(new Rectangle2D.Double(5.0, 6.0, 7.0, 8.0));
        harness.check(((RectangularShape)r1).getX(), 5.0);
        harness.check(((RectangularShape)r1).getY(), 6.0);
        harness.check(((RectangularShape)r1).getWidth(), 7.0);
        harness.check(((RectangularShape)r1).getHeight(), 8.0);
        boolean pass = false;
        try {
            ((Rectangle2D)r1).setRect(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

