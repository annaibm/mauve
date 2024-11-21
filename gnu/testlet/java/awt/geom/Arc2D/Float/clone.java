/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.RectangularShape;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Float arc1 = new Arc2D.Float(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 2);
        Arc2D arc2 = null;
        arc2 = (Arc2D)arc1.clone();
        harness.check(((RectangularShape)arc1).getX() == arc2.getX());
        harness.check(((RectangularShape)arc1).getY() == arc2.getY());
        harness.check(((RectangularShape)arc1).getWidth() == arc2.getWidth());
        harness.check(((RectangularShape)arc1).getHeight() == arc2.getHeight());
        harness.check(((Arc2D)arc1).getAngleStart(), arc2.getAngleStart());
        harness.check(((Arc2D)arc1).getAngleExtent(), arc2.getAngleExtent());
        harness.check(arc1.getArcType() == arc2.getArcType());
        harness.check(arc1.getClass() == arc2.getClass());
        harness.check(arc1 != arc2);
    }
}

