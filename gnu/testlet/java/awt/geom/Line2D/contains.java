/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(!line1.contains(1.0, 2.0));
        harness.check(!line1.contains(3.0, 4.0));
        harness.check(!line1.contains(new Point2D.Double(1.0, 2.0)));
        harness.check(!line1.contains(new Point2D.Double(3.0, 4.0)));
        harness.check(!line1.contains((Point2D)null));
        harness.check(!line1.contains(new Rectangle2D.Double(1.0, 2.0, 0.0, 0.0)));
        harness.check(!line1.contains((Rectangle2D)null));
    }
}

