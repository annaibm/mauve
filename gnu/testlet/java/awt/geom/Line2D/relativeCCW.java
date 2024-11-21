/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class relativeCCW
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, 1.0, 1.0) == 0);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, 3.0, 2.0) == 0);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, 0.0, 0.0) == 1);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, -1.0, 0.0) == -1);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, 5.0, 3.0) == 1);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, 5.0, 4.0) == -1);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 3.0, 2.0, -1.0, -1.0) == 1);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 1.0, 1.0, 1.0, 1.0) == 0);
        harness.check(Line2D.relativeCCW(1.0, 1.0, 1.0, 1.0, 2.0, 2.0) == 0);
        Line2D.Double line1 = new Line2D.Double(1.0, 1.0, 3.0, 2.0);
        harness.check(line1.relativeCCW(1.0, 1.0) == 0);
        harness.check(line1.relativeCCW(3.0, 2.0) == 0);
        harness.check(line1.relativeCCW(0.0, 0.0) == 1);
        harness.check(line1.relativeCCW(-1.0, 0.0) == -1);
        harness.check(line1.relativeCCW(5.0, 3.0) == 1);
        harness.check(line1.relativeCCW(5.0, 4.0) == -1);
        harness.check(line1.relativeCCW(-1.0, -1.0) == 1);
        harness.check(line1.relativeCCW(new Point2D.Double(1.0, 1.0)) == 0);
        harness.check(line1.relativeCCW(new Point2D.Double(3.0, 2.0)) == 0);
        harness.check(line1.relativeCCW(new Point2D.Double(0.0, 0.0)) == 1);
        harness.check(line1.relativeCCW(new Point2D.Double(-1.0, 0.0)) == -1);
        harness.check(line1.relativeCCW(new Point2D.Double(5.0, 3.0)) == 1);
        harness.check(line1.relativeCCW(new Point2D.Double(5.0, 4.0)) == -1);
        harness.check(line1.relativeCCW(new Point2D.Double(-1.0, -1.0)) == 1);
        boolean pass = false;
        try {
            line1.relativeCCW(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

