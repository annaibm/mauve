/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;

public class intersectsLine
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double r = new Rectangle2D.Double(0.0, 0.0, 5.0, 10.0);
        harness.check(r.intersectsLine(0.0, 0.0, 5.0, 0.0));
        harness.check(r.intersectsLine(0.0, 0.0, 0.0, 10.0));
        harness.check(r.intersectsLine(5.0, 0.0, 5.0, 10.0));
        harness.check(r.intersectsLine(0.0, 10.0, 5.0, 10.0));
        harness.check(!r.intersectsLine(-1.0, -1.0, -2.0, -2.0));
        harness.check(r.intersectsLine(-5.0, 2.0, 15.0, 2.0));
        harness.check(r.intersectsLine(-1.0, 0.0, 0.0, 0.0));
        harness.check(r.intersectsLine(5.0, -1.0, 5.0, 0.0));
        harness.check(r.intersectsLine(-1.0, 10.0, 0.0, 10.0));
        harness.check(r.intersectsLine(5.0, 11.0, 5.0, 10.0));
        r = new Rectangle2D.Double();
        harness.check(!r.intersectsLine(0.0, 0.0, 0.0, 0.0));
        boolean pass = false;
        try {
            r.intersectsLine(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

