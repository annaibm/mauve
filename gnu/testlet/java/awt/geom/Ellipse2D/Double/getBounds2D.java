/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Ellipse2D.Double e = new Ellipse2D.Double();
        Rectangle2D b = e.getBounds2D();
        harness.check(b.getX(), 0.0);
        harness.check(b.getY(), 0.0);
        harness.check(b.getWidth(), 0.0);
        harness.check(b.getHeight(), 0.0);
        e = new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0);
        b = e.getBounds2D();
        harness.check(b.getX(), 1.0);
        harness.check(b.getY(), 2.0);
        harness.check(b.getWidth(), 3.0);
        harness.check(b.getHeight(), 4.0);
    }
}

