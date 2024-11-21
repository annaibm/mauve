/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.RectangularShape;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class getFrame
implements Testlet {
    public static void testOneInstance(RectangularShape r, TestHarness harness) {
        r.setFrame(1.0, 2.0, 3.0, 4.0);
        Rectangle2D f = r.getFrame();
        harness.check(f.getX(), 1.0);
        harness.check(f.getY(), 2.0);
        harness.check(f.getWidth(), 3.0);
        harness.check(f.getHeight(), 4.0);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Arc2D.Float");
        getFrame.testOneInstance(new Arc2D.Float(), harness);
        harness.checkPoint("Arc2D.Double");
        getFrame.testOneInstance(new Arc2D.Double(), harness);
        harness.checkPoint("Ellipse2D.Float");
        getFrame.testOneInstance(new Ellipse2D.Float(), harness);
        harness.checkPoint("Ellipse2D.Double");
        getFrame.testOneInstance(new Ellipse2D.Double(), harness);
        harness.checkPoint("Rectangle2D.Float");
        getFrame.testOneInstance(new Rectangle2D.Float(), harness);
        harness.checkPoint("Rectangle2D.Double");
        getFrame.testOneInstance(new Rectangle2D.Double(), harness);
        harness.checkPoint("RoundRectangle2D.Float");
        getFrame.testOneInstance(new RoundRectangle2D.Float(), harness);
        harness.checkPoint("RoundRectangle2D.Double");
        getFrame.testOneInstance(new RoundRectangle2D.Double(), harness);
        harness.checkPoint("Rectangle");
        getFrame.testOneInstance(new Rectangle(), harness);
    }
}

