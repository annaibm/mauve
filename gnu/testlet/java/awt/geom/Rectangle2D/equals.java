/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r1 = new Rectangle2D.Double();
        Rectangle2D.Double r2 = new Rectangle2D.Double();
        harness.check(r1.equals(r2));
        harness.check(r2.equals(r1));
        harness.check(!r1.equals(null));
        r1 = new Rectangle2D.Double(1.0, 0.0, 0.0, 0.0);
        harness.check(!r1.equals(r2));
        r2 = new Rectangle2D.Double(1.0, 0.0, 0.0, 0.0);
        harness.check(r1.equals(r2));
        r1 = new Rectangle2D.Double(1.0, 2.0, 0.0, 0.0);
        harness.check(!r1.equals(r2));
        r2 = new Rectangle2D.Double(1.0, 2.0, 0.0, 0.0);
        harness.check(r1.equals(r2));
        r1 = new Rectangle2D.Double(1.0, 2.0, 3.0, 0.0);
        harness.check(!r1.equals(r2));
        r2 = new Rectangle2D.Double(1.0, 2.0, 3.0, 0.0);
        harness.check(r1.equals(r2));
        r1 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(!r1.equals(r2));
        r2 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(r1.equals(r2));
    }
}

