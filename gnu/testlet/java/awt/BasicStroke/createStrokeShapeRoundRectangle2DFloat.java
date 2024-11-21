/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class createStrokeShapeRoundRectangle2DFloat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicStroke basicStroke = new BasicStroke(10.0f);
        RoundRectangle2D.Float s1 = new RoundRectangle2D.Float(0.0f, 0.0f, 100.0f, 100.0f, 40.0f, 40.0f);
        Shape s2 = basicStroke.createStrokedShape(s1);
        harness.check(s2.contains(0.0, 40.0));
        harness.check(s2.contains(40.0, 0.0));
        harness.check(s2.contains(60.0, 0.0));
        harness.check(s2.contains(100.0, 40.0));
        harness.check(s2.contains(0.0, 60.0));
        harness.check(s2.contains(40.0, 100.0));
        harness.check(s2.contains(60.0, 100.0));
        harness.check(s2.contains(100.0, 60.0));
        harness.check(!s2.contains(50.0, 50.0));
        harness.check(!s2.contains(10.0, 10.0));
        harness.check(!s2.contains(10.0, 90.0));
        harness.check(!s2.contains(90.0, 90.0));
        harness.check(!s2.contains(90.0, 10.0));
        harness.check(s2.contains(50.0, 4.0));
        harness.check(s2.contains(4.0, 50.0));
        harness.check(!s2.contains(50.0, 6.0));
        harness.check(!s2.contains(50.0, 10.0));
        harness.check(!s2.contains(6.0, 50.0));
        harness.check(!s2.contains(10.0, 50.0));
    }
}

