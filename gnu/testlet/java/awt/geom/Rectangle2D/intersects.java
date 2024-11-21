/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;

public class intersects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r = new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0);
        harness.check(!r.intersects(-1.0, -1.0, 1.0, 1.0));
        harness.check(!r.intersects(-1.0, 0.0, 1.0, 1.0));
        harness.check(!r.intersects(0.0, -1.0, 1.0, 1.0));
        harness.check(r.intersects(0.0, 0.0, 1.0, 1.0));
        r = new Rectangle2D.Double();
        harness.check(!r.intersects(0.0, 0.0, 0.0, 0.0));
    }
}

