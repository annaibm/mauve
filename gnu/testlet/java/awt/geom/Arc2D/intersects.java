/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class intersects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        harness.check(!arc.intersects(0.0, 0.0, 0.0, 0.0));
        harness.check(!arc.intersects(1.0, 2.0, 3.0, 4.0));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 2);
        harness.check(arc.intersects(-1.0, 0.0, 1.0, 1.0));
        harness.check(arc.intersects(-1.0, -1.0, 1.0, 1.0));
        harness.check(arc.intersects(0.0, 0.0, 1.0, 1.0));
        harness.check(arc.intersects(0.0, -1.0, 1.0, 1.0));
        harness.check(!arc.intersects(5.0, 5.0, 1.0, 1.0));
        arc = new Arc2D.Double();
        harness.check(!arc.intersects(new Rectangle2D.Double(0.0, 0.0, 0.0, 0.0)));
        boolean pass = false;
        try {
            arc.intersects(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

