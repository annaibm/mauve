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

public class isEmpty
implements Testlet {
    public static void testOneInstance(RectangularShape r, TestHarness harness) {
        r.setFrame(0.0, 0.0, 0.0, 0.0);
        harness.check(r.isEmpty());
        r.setFrame(-1.0, -2.0, -3.0, -4.0);
        harness.check(r.isEmpty());
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Arc2D.Float");
        isEmpty.testOneInstance(new Arc2D.Float(), harness);
        harness.checkPoint("Arc2D.Double");
        isEmpty.testOneInstance(new Arc2D.Double(), harness);
        harness.checkPoint("Ellipse2D.Float");
        isEmpty.testOneInstance(new Ellipse2D.Float(), harness);
        harness.checkPoint("Ellipse2D.Double");
        isEmpty.testOneInstance(new Ellipse2D.Double(), harness);
        harness.checkPoint("Rectangle2D.Float");
        isEmpty.testOneInstance(new Rectangle2D.Float(), harness);
        harness.checkPoint("Rectangle2D.Double");
        isEmpty.testOneInstance(new Rectangle2D.Double(), harness);
        harness.checkPoint("RoundRectangle2D.Float");
        isEmpty.testOneInstance(new RoundRectangle2D.Float(), harness);
        harness.checkPoint("RoundRectangle2D.Double");
        isEmpty.testOneInstance(new RoundRectangle2D.Double(), harness);
        harness.checkPoint("Rectangle");
        isEmpty.testOneInstance(new Rectangle(), harness);
    }
}

