/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r = new Rectangle2D.Double();
        harness.check(((RectangularShape)r).isEmpty());
        r = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(!((RectangularShape)r).isEmpty());
        r = new Rectangle2D.Double(1.0, 2.0, -3.0, 4.0);
        harness.check(((RectangularShape)r).isEmpty());
        r = new Rectangle2D.Double(1.0, 2.0, 3.0, -4.0);
        harness.check(((RectangularShape)r).isEmpty());
    }
}

