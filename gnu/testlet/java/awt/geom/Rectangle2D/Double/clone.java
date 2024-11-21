/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r1 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        Rectangle2D r2 = null;
        r2 = (Rectangle2D)r1.clone();
        harness.check(((RectangularShape)r1).getX() == r2.getX());
        harness.check(((RectangularShape)r1).getY() == r2.getY());
        harness.check(((RectangularShape)r1).getWidth() == r2.getWidth());
        harness.check(((RectangularShape)r1).getHeight() == r2.getHeight());
        harness.check(r1.getClass() == r2.getClass());
        harness.check(r1 != r2);
    }
}

