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

public class setFrameFromDiagonal
implements Testlet {
    public static void testOneInstance(RectangularShape r, TestHarness harness) {
        r.setFrameFromDiagonal(1.0, 2.0, 3.0, 4.0);
        harness.check(r.getX(), 1.0);
        harness.check(r.getY(), 2.0);
        harness.check(r.getWidth(), 2.0);
        harness.check(r.getHeight(), 2.0);
        r.setFrameFromDiagonal(new Point2D.Double(4.0, 3.0), new Point2D.Double(2.0, 1.0));
        harness.check(r.getX(), 2.0);
        harness.check(r.getY(), 1.0);
        harness.check(r.getWidth(), 2.0);
        harness.check(r.getHeight(), 2.0);
        boolean pass = false;
        try {
            r.setFrameFromDiagonal(null, new Point2D.Double());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            r.setFrameFromDiagonal(new Point2D.Double(), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Arc2D.Float");
        setFrameFromDiagonal.testOneInstance(new Arc2D.Float(), harness);
        harness.checkPoint("Arc2D.Double");
        setFrameFromDiagonal.testOneInstance(new Arc2D.Double(), harness);
        harness.checkPoint("Ellipse2D.Float");
        setFrameFromDiagonal.testOneInstance(new Ellipse2D.Float(), harness);
        harness.checkPoint("Ellipse2D.Double");
        setFrameFromDiagonal.testOneInstance(new Ellipse2D.Double(), harness);
        harness.checkPoint("Rectangle2D.Float");
        setFrameFromDiagonal.testOneInstance(new Rectangle2D.Float(), harness);
        harness.checkPoint("Rectangle2D.Double");
        setFrameFromDiagonal.testOneInstance(new Rectangle2D.Double(), harness);
        harness.checkPoint("RoundRectangle2D.Float");
        setFrameFromDiagonal.testOneInstance(new RoundRectangle2D.Float(), harness);
        harness.checkPoint("RoundRectangle2D.Double");
        setFrameFromDiagonal.testOneInstance(new RoundRectangle2D.Double(), harness);
        harness.checkPoint("Rectangle");
        setFrameFromDiagonal.testOneInstance(new Rectangle(), harness);
    }
}

