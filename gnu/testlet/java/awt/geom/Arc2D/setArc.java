/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class setArc
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc1 = new Arc2D.Double();
        Arc2D.Double arc2 = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 2);
        arc1.setArc(arc2);
        harness.check(((RectangularShape)arc1).getX(), 1.0);
        harness.check(((RectangularShape)arc1).getY(), 2.0);
        harness.check(((RectangularShape)arc1).getWidth(), 3.0);
        harness.check(((RectangularShape)arc1).getHeight(), 4.0);
        harness.check(((Arc2D)arc1).getAngleStart(), 5.0);
        harness.check(((Arc2D)arc1).getAngleExtent(), 6.0);
        harness.check(arc1.getArcType() == 2);
        boolean pass = false;
        try {
            arc1.setArc(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        arc1 = new Arc2D.Double();
        ((Arc2D)arc1).setArc(6.0, 5.0, 4.0, 3.0, 2.0, 1.0, 0);
        harness.check(((RectangularShape)arc1).getX(), 6.0);
        harness.check(((RectangularShape)arc1).getY(), 5.0);
        harness.check(((RectangularShape)arc1).getWidth(), 4.0);
        harness.check(((RectangularShape)arc1).getHeight(), 3.0);
        harness.check(((Arc2D)arc1).getAngleStart(), 2.0);
        harness.check(((Arc2D)arc1).getAngleExtent(), 1.0);
        harness.check(arc1.getArcType() == 0);
        arc1 = new Arc2D.Double();
        arc1.setArc(new Point2D.Double(1.0, 2.0), new Dimension(3, 4), 5.0, 6.0, 1);
        harness.check(((RectangularShape)arc1).getX(), 1.0);
        harness.check(((RectangularShape)arc1).getY(), 2.0);
        harness.check(((RectangularShape)arc1).getWidth(), 3.0);
        harness.check(((RectangularShape)arc1).getHeight(), 4.0);
        harness.check(((Arc2D)arc1).getAngleStart(), 5.0);
        harness.check(((Arc2D)arc1).getAngleExtent(), 6.0);
        harness.check(arc1.getArcType() == 1);
        pass = false;
        try {
            arc1.setArc(null, new Dimension(3, 4), 5.0, 6.0, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            arc1.setArc(new Point2D.Double(1.0, 2.0), null, 5.0, 6.0, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        arc1 = new Arc2D.Double();
        arc1.setArc(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), 5.0, 6.0, 0);
        harness.check(((RectangularShape)arc1).getX(), 1.0);
        harness.check(((RectangularShape)arc1).getY(), 2.0);
        harness.check(((RectangularShape)arc1).getWidth(), 3.0);
        harness.check(((RectangularShape)arc1).getHeight(), 4.0);
        harness.check(((Arc2D)arc1).getAngleStart(), 5.0);
        harness.check(((Arc2D)arc1).getAngleExtent(), 6.0);
        harness.check(arc1.getArcType() == 0);
        pass = false;
        try {
            arc1.setArc(null, 5.0, 6.0, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

