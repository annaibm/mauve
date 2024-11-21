/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r = new Rectangle2D.Double();
        harness.check(!r.contains(0.0, 0.0));
        r = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(r.contains(1.0, 2.0));
        harness.check(!r.contains(1.0, 6.0));
        harness.check(!r.contains(4.0, 2.0));
        harness.check(!r.contains(4.0, 6.0));
        r = new Rectangle2D.Double();
        harness.check(!r.contains(0.0, 0.0, 0.0, 0.0));
        r = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(r.contains(1.0, 2.0, 3.0, 4.0));
        harness.check(!r.contains(1.0, 2.0, 4.0, 4.0));
    }
}

