/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class createStrokeShapeLine2DDouble
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicStroke basicStroke = new BasicStroke(10.0f);
        Line2D.Double s1 = new Line2D.Double(0.0, 0.0, 100.0, 100.0);
        Shape s2 = basicStroke.createStrokedShape(s1);
        harness.check(s2.contains(0.0, 0.0));
        harness.check(s2.contains(50.0, 50.0));
        harness.check(s2.contains(100.0, 100.0));
        harness.check(!s2.contains(0.0, 100.0));
        harness.check(!s2.contains(100.0, 0.0));
        for (int i = 0; i < 100; ++i) {
            harness.check(s2.contains(i, i));
        }
        harness.check(!s2.contains(50.0, 40.0));
        harness.check(!s2.contains(50.0, 60.0));
        harness.check(!s2.contains(40.0, 50.0));
        harness.check(!s2.contains(60.0, 50.0));
    }
}

