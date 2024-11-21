/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class setFrame
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r1 = new Rectangle2D.Double();
        r1.setFrame(1.0, 2.0, 3.0, 4.0);
        harness.check(((RectangularShape)r1).getX(), 1.0);
        harness.check(((RectangularShape)r1).getY(), 2.0);
        harness.check(((RectangularShape)r1).getWidth(), 3.0);
        harness.check(((RectangularShape)r1).getHeight(), 4.0);
    }
}

