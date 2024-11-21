/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Float r = new Rectangle2D.Float();
        harness.check(((RectangularShape)r).isEmpty());
        r = new Rectangle2D.Float(1.0f, 2.0f, 3.0f, 4.0f);
        harness.check(!((RectangularShape)r).isEmpty());
        r = new Rectangle2D.Float(1.0f, 2.0f, -3.0f, 4.0f);
        harness.check(((RectangularShape)r).isEmpty());
        r = new Rectangle2D.Float(1.0f, 2.0f, 3.0f, -4.0f);
        harness.check(((RectangularShape)r).isEmpty());
    }
}

