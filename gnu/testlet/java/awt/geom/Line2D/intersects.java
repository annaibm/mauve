/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class intersects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(0.0, 0.0, 1.0, 0.0);
        harness.check(line1.intersects(0.0, -1.0, 1.0, 1.0));
        harness.check(line1.intersects(0.0, 0.0, 1.0, 1.0));
        harness.check(!line1.intersects(0.0, 1.0, 1.0, 1.0));
        harness.check(line1.intersects(new Rectangle2D.Double(0.0, -1.0, 1.0, 1.0)));
        harness.check(line1.intersects(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0)));
        harness.check(!line1.intersects(new Rectangle2D.Double(0.0, 1.0, 1.0, 1.0)));
        Line2D.Double line2 = new Line2D.Double(0.0, 0.0, 0.0, 1.0);
        harness.check(line2.intersects(-1.0, 0.0, 1.0, 1.0));
        harness.check(line2.intersects(0.0, 0.0, 1.0, 1.0));
        harness.check(!line2.intersects(1.0, 0.0, 1.0, 1.0));
        harness.check(line2.intersects(new Rectangle2D.Double(-1.0, 0.0, 1.0, 1.0)));
        harness.check(line2.intersects(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0)));
        harness.check(!line2.intersects(new Rectangle2D.Double(1.0, 0.0, 1.0, 1.0)));
        Line2D.Double line3 = new Line2D.Double(0.0, 1.0, 1.0, 1.0);
        harness.check(!line3.intersects(0.0, -1.0, 1.0, 1.0));
        harness.check(line3.intersects(0.0, 0.0, 1.0, 1.0));
        harness.check(line3.intersects(0.0, 1.0, 1.0, 1.0));
        harness.check(!line3.intersects(new Rectangle2D.Double(0.0, -1.0, 1.0, 1.0)));
        harness.check(line3.intersects(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0)));
        harness.check(line3.intersects(new Rectangle2D.Double(0.0, 1.0, 1.0, 1.0)));
        Line2D.Double line4 = new Line2D.Double(1.0, 0.0, 1.0, 1.0);
        harness.check(!line4.intersects(-1.0, 0.0, 1.0, 1.0));
        harness.check(line4.intersects(0.0, 0.0, 1.0, 1.0));
        harness.check(line4.intersects(1.0, 0.0, 1.0, 1.0));
        harness.check(!line4.intersects(new Rectangle2D.Double(-1.0, 0.0, 1.0, 1.0)));
        harness.check(line4.intersects(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0)));
        harness.check(line4.intersects(new Rectangle2D.Double(1.0, 0.0, 1.0, 1.0)));
        boolean pass = false;
        try {
            line4.intersects(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

