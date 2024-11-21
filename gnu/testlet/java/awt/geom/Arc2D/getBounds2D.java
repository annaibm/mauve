/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        Rectangle2D b = arc.getBounds2D();
        harness.check(b.getX(), 0.0);
        harness.check(b.getY(), 0.0);
        harness.check(b.getWidth(), 0.0);
        harness.check(b.getHeight(), 0.0);
        arc = new Arc2D.Double(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), 90.0, 90.0, 2);
        b = arc.getBounds2D();
        harness.check(b.getX(), 0.0);
        harness.check(b.getY(), 0.0);
        harness.check(b.getWidth(), 0.5);
        harness.check(b.getHeight(), 0.5);
    }
}

