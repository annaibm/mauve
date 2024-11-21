/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;

public class createUnion
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r0 = new Rectangle2D.Double();
        Rectangle2D r1 = ((Rectangle2D)r0).createUnion(new Rectangle2D.Double());
        harness.check(r1.getX(), 0.0);
        harness.check(r1.getY(), 0.0);
        harness.check(r1.getWidth(), 0.0);
        harness.check(r1.getHeight(), 0.0);
        r0 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        r1 = new Rectangle2D.Double(1.5, 2.5, 3.5, 4.5);
        Rectangle2D r2 = ((Rectangle2D)r0).createUnion(r1);
        harness.check(r2.getX(), 1.0);
        harness.check(r2.getY(), 2.0);
        harness.check(r2.getWidth(), 4.0);
        harness.check(r2.getHeight(), 5.0);
        r0 = new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0);
        r1 = new Rectangle2D.Double(3.0, 3.0, 1.0, 1.0);
        r2 = ((Rectangle2D)r0).createUnion(r1);
        harness.check(r2.getX(), 1.0);
        harness.check(r2.getY(), 1.0);
        harness.check(r2.getWidth(), 3.0);
        harness.check(r2.getHeight(), 3.0);
    }
}

