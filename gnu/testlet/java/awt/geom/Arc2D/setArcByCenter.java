/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.RectangularShape;

public class setArcByCenter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc1 = new Arc2D.Double();
        arc1.setArcByCenter(1.0, 2.0, 3.0, 4.0, 5.0, 2);
        harness.check(((RectangularShape)arc1).getX(), -2.0);
        harness.check(((RectangularShape)arc1).getY(), -1.0);
        harness.check(((RectangularShape)arc1).getWidth(), 6.0);
        harness.check(((RectangularShape)arc1).getHeight(), 6.0);
        harness.check(((Arc2D)arc1).getAngleStart(), 4.0);
        harness.check(((Arc2D)arc1).getAngleExtent(), 5.0);
        harness.check(arc1.getArcType() == 2);
        boolean pass = false;
        try {
            arc1.setArcByCenter(1.0, 2.0, 3.0, 4.0, 5.0, 99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

