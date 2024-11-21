/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class getP1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        Point2D pt1 = ((Line2D)line1).getP1();
        harness.check(pt1.getX() == 1.0);
        harness.check(pt1.getY() == 2.0);
    }
}

