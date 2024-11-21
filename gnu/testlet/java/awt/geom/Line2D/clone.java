/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        Line2D line2 = null;
        line2 = (Line2D)line1.clone();
        harness.check(((Line2D)line1).getX1() == line2.getX1());
        harness.check(((Line2D)line1).getX2() == line2.getX2());
        harness.check(((Line2D)line1).getY1() == line2.getY1());
        harness.check(((Line2D)line1).getY2() == line2.getY2());
        harness.check(line1.getClass() == line2.getClass());
        harness.check(line1 != line2);
    }
}

