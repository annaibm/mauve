/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.RectangularShape;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class setFrameFromCenter
implements Testlet {
    public static void testOneInstance(RectangularShape r, TestHarness harness) {
        r.setFrameFromCenter(1.0, 2.0, 3.0, 4.0);
        harness.check(r.getX(), -1.0);
        harness.check(r.getY(), 0.0);
        harness.check(r.getWidth(), 4.0);
        harness.check(r.getHeight(), 4.0);
        r.setFrameFromCenter(new Point2D.Double(4.0, 3.0), new Point2D.Double(2.0, 1.0));
        harness.check(r.getX(), 2.0);
        harness.check(r.getY(), 1.0);
        harness.check(r.getWidth(), 4.0);
        harness.check(r.getHeight(), 4.0);
        boolean pass = false;
        try {
            r.setFrameFromCenter(null, new Point2D.Double());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            r.setFrameFromCenter(new Point2D.Double(), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Arc2D.Float");
        setFrameFromCenter.testOneInstance(new Arc2D.Float(), harness);
        harness.checkPoint("Arc2D.Double");
        setFrameFromCenter.testOneInstance(new Arc2D.Double(), harness);
        harness.checkPoint("Ellipse2D.Float");
        setFrameFromCenter.testOneInstance(new Ellipse2D.Float(), harness);
        harness.checkPoint("Ellipse2D.Double");
        setFrameFromCenter.testOneInstance(new Ellipse2D.Double(), harness);
        harness.checkPoint("Rectangle2D.Float");
        setFrameFromCenter.testOneInstance(new Rectangle2D.Float(), harness);
        harness.checkPoint("Rectangle2D.Double");
        setFrameFromCenter.testOneInstance(new Rectangle2D.Double(), harness);
        harness.checkPoint("RoundRectangle2D.Float");
        setFrameFromCenter.testOneInstance(new RoundRectangle2D.Float(), harness);
        harness.checkPoint("RoundRectangle2D.Double");
        setFrameFromCenter.testOneInstance(new RoundRectangle2D.Double(), harness);
        harness.checkPoint("Rectangle");
        setFrameFromCenter.testOneInstance(new Rectangle(), harness);
    }
}

