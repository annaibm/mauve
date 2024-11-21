/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class setLine
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double();
        ((Line2D)line1).setLine(1.0, 2.0, 3.0, 4.0);
        harness.check(((Line2D)line1).getX1() == 1.0);
        harness.check(((Line2D)line1).getY1() == 2.0);
        harness.check(((Line2D)line1).getX2() == 3.0);
        harness.check(((Line2D)line1).getY2() == 4.0);
        line1.setLine(new Point2D.Double(1.1, 2.2), new Point2D.Double(3.3, 4.4));
        harness.check(((Line2D)line1).getX1() == 1.1);
        harness.check(((Line2D)line1).getY1() == 2.2);
        harness.check(((Line2D)line1).getX2() == 3.3);
        harness.check(((Line2D)line1).getY2() == 4.4);
        line1.setLine(new Line2D.Double(1.11, 2.22, 3.33, 4.44));
        harness.check(((Line2D)line1).getX1() == 1.11);
        harness.check(((Line2D)line1).getY1() == 2.22);
        harness.check(((Line2D)line1).getX2() == 3.33);
        harness.check(((Line2D)line1).getY2() == 4.44);
        Line2D.Float line2 = new Line2D.Float();
        ((Line2D)line2).setLine(1.1, 2.2, 3.3, 4.4);
        harness.check(((Line2D)line2).getX1() == (double)1.1f);
        harness.check(((Line2D)line2).getY1() == (double)2.2f);
        harness.check(((Line2D)line2).getX2() == (double)3.3f);
        harness.check(((Line2D)line2).getY2() == (double)4.4f);
        line2.setLine(new Point2D.Float(1.1f, 2.2f), new Point2D.Float(3.3f, 4.4f));
        harness.check(((Line2D)line2).getX1() == (double)1.1f);
        harness.check(((Line2D)line2).getY1() == (double)2.2f);
        harness.check(((Line2D)line2).getX2() == (double)3.3f);
        harness.check(((Line2D)line2).getY2() == (double)4.4f);
        line2.setLine(new Line2D.Float(1.11f, 2.22f, 3.33f, 4.44f));
        harness.check(((Line2D)line2).getX1() == (double)1.11f);
        harness.check(((Line2D)line2).getY1() == (double)2.22f);
        harness.check(((Line2D)line2).getX2() == (double)3.33f);
        harness.check(((Line2D)line2).getY2() == (double)4.44f);
        boolean pass = false;
        try {
            line1.setLine(null, new Point2D.Double());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            line1.setLine(new Point2D.Double(), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            line1.setLine(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

