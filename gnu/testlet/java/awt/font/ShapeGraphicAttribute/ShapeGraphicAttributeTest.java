/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.ShapeGraphicAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.ShapeGraphicAttribute;
import java.awt.geom.Rectangle2D;

public class ShapeGraphicAttributeTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            Rectangle2D.Float s = new Rectangle2D.Float(2.0f, 3.0f, 60.0f, 98.0f);
            ShapeGraphicAttribute sga = new ShapeGraphicAttribute(s, 0, true);
            harness.check(sga.hashCode(), ((Object)s).hashCode());
            harness.check(sga.getAscent(), 0.0);
            harness.check(sga.getDescent(), 101.0);
            harness.check(sga.getAdvance(), 62.0);
            harness.check(sga.getBounds(), new Rectangle2D.Float(2.0f, 3.0f, 61.0f, 99.0f));
            Rectangle2D.Float s2 = new Rectangle2D.Float(2.0f, -5.0f, 17.0f, 921.0f);
            ShapeGraphicAttribute sga2 = new ShapeGraphicAttribute(s2, 1, false);
            harness.check(sga2.hashCode(), ((Object)s2).hashCode());
            harness.check(sga2.getAscent(), 5.0);
            harness.check(sga2.getDescent(), 916.0);
            harness.check(sga2.getAdvance(), 19.0);
            harness.check(sga2.getBounds(), new Rectangle2D.Float(2.0f, -5.0f, 17.0f, 921.0f));
            harness.check(sga.equals(sga2), false);
        }
        catch (Exception e) {
            harness.fail("Exception caught: " + e);
        }
    }
}

