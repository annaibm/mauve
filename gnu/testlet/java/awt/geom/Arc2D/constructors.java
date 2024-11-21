/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        harness.check(arc.getArcType() == 0);
        harness.check(((RectangularShape)arc).getX(), 0.0);
        harness.check(((RectangularShape)arc).getY(), 0.0);
        harness.check(((RectangularShape)arc).getWidth(), 0.0);
        harness.check(((RectangularShape)arc).getHeight(), 0.0);
        harness.check(((Arc2D)arc).getAngleStart(), 0.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 0.0);
        arc = new Arc2D.Double(2);
        harness.check(arc.getArcType() == 2);
        harness.check(((RectangularShape)arc).getX(), 0.0);
        harness.check(((RectangularShape)arc).getY(), 0.0);
        harness.check(((RectangularShape)arc).getWidth(), 0.0);
        harness.check(((RectangularShape)arc).getHeight(), 0.0);
        harness.check(((Arc2D)arc).getAngleStart(), 0.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 0.0);
        arc = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 45.0, 90.0, 1);
        harness.check(arc.getArcType() == 1);
        harness.check(((RectangularShape)arc).getX(), 1.0);
        harness.check(((RectangularShape)arc).getY(), 2.0);
        harness.check(((RectangularShape)arc).getWidth(), 3.0);
        harness.check(((RectangularShape)arc).getHeight(), 4.0);
        harness.check(((Arc2D)arc).getAngleStart(), 45.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 90.0);
        boolean pass = false;
        try {
            arc = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 45.0, 90.0, 99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        arc = new Arc2D.Double(new Rectangle2D.Double(10.0, 11.0, 12.0, 13.0), 110.0, 35.0, 0);
        harness.check(arc.getArcType() == 0);
        harness.check(((RectangularShape)arc).getX(), 10.0);
        harness.check(((RectangularShape)arc).getY(), 11.0);
        harness.check(((RectangularShape)arc).getWidth(), 12.0);
        harness.check(((RectangularShape)arc).getHeight(), 13.0);
        harness.check(((Arc2D)arc).getAngleStart(), 110.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 35.0);
        pass = false;
        try {
            arc = new Arc2D.Double(null, 110.0, 35.0, 0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

