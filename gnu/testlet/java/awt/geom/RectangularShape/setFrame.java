/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.RectangularShape;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class setFrame
implements Testlet {
    public static void testOneInstance(RectangularShape r, TestHarness harness) {
        r.setFrame(1.0, 2.0, 3.0, 4.0);
        harness.check(r.getX(), 1.0);
        harness.check(r.getY(), 2.0);
        harness.check(r.getWidth(), 3.0);
        harness.check(r.getHeight(), 4.0);
        r.setFrame(new Point2D.Double(4.0, 3.0), new Dimension(2, 1));
        harness.check(r.getX(), 4.0);
        harness.check(r.getY(), 3.0);
        harness.check(r.getWidth(), 2.0);
        harness.check(r.getHeight(), 1.0);
        boolean pass = false;
        try {
            r.setFrame(null, new Dimension(2, 1));
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            r.setFrame(new Point2D.Double(4.0, 3.0), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        r.setFrame(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(r.getX(), 1.0);
        harness.check(r.getY(), 2.0);
        harness.check(r.getWidth(), 3.0);
        harness.check(r.getHeight(), 4.0);
        pass = false;
        try {
            r.setFrame(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Arc2D.Float");
        setFrame.testOneInstance(new Arc2D.Float(), harness);
        harness.checkPoint("Arc2D.Double");
        setFrame.testOneInstance(new Arc2D.Double(), harness);
        harness.checkPoint("Ellipse2D.Float");
        setFrame.testOneInstance(new Ellipse2D.Float(), harness);
        harness.checkPoint("Ellipse2D.Double");
        setFrame.testOneInstance(new Ellipse2D.Double(), harness);
        harness.checkPoint("Rectangle2D.Float");
        setFrame.testOneInstance(new Rectangle2D.Float(), harness);
        harness.checkPoint("Rectangle2D.Double");
        setFrame.testOneInstance(new Rectangle2D.Double(), harness);
        harness.checkPoint("RoundRectangle2D.Float");
        setFrame.testOneInstance(new RoundRectangle2D.Float(), harness);
        harness.checkPoint("RoundRectangle2D.Double");
        setFrame.testOneInstance(new RoundRectangle2D.Double(), harness);
        harness.checkPoint("Rectangle");
        setFrame.testOneInstance(new Rectangle(), harness);
    }
}

