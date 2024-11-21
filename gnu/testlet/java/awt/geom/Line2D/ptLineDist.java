/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class ptLineDist
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(0.0, 0.0, 1.0, 0.0);
        harness.check(0.0, line1.ptLineDist(-50.0, 0.0));
        harness.check(0.0, line1.ptLineDist(0.0, 0.0));
        harness.check(0.0, line1.ptLineDist(1.0, 0.0));
        harness.check(0.0, line1.ptLineDist(50.0, 0.0));
        harness.check(1.0, line1.ptLineDist(-50.0, 1.0));
        harness.check(1.0, line1.ptLineDist(0.0, 1.0));
        harness.check(1.0, line1.ptLineDist(1.0, 1.0));
        harness.check(1.0, line1.ptLineDist(50.0, 1.0));
        harness.check(1.0, line1.ptLineDist(-50.0, -1.0));
        harness.check(1.0, line1.ptLineDist(0.0, -1.0));
        harness.check(1.0, line1.ptLineDist(1.0, -1.0));
        harness.check(1.0, line1.ptLineDist(50.0, -1.0));
        harness.check(0.0, line1.ptLineDist(new Point2D.Double(-50.0, 0.0)));
        harness.check(0.0, line1.ptLineDist(new Point2D.Double(0.0, 0.0)));
        harness.check(0.0, line1.ptLineDist(new Point2D.Double(1.0, 0.0)));
        harness.check(0.0, line1.ptLineDist(new Point2D.Double(50.0, 0.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(-50.0, 1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(0.0, 1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(1.0, 1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(50.0, 1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(-50.0, -1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(0.0, -1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(1.0, -1.0)));
        harness.check(1.0, line1.ptLineDist(new Point2D.Double(50.0, -1.0)));
        boolean pass = false;
        try {
            line1.ptLineDist(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

