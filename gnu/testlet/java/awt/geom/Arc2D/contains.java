/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        harness.check(!arc.contains(0.0, 0.0));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 1);
        harness.check(!arc.contains(0.0, 0.0));
        harness.check(!arc.contains(1.0, 0.0));
        harness.check(!arc.contains(0.0, 1.0));
        harness.check(!arc.contains(0.5, 0.5));
        harness.check(!arc.contains(0.5, -0.5));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 2);
        harness.check(arc.contains(0.0, 0.0));
        harness.check(!arc.contains(1.0, 0.0));
        harness.check(!arc.contains(0.0, 1.0));
        harness.check(!arc.contains(0.5, 0.5));
        harness.check(arc.contains(0.5, -0.5));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 0);
        harness.check(!arc.contains(0.0, 0.0));
        harness.check(!arc.contains(1.0, 0.0));
        harness.check(!arc.contains(0.0, 1.0));
        harness.check(!arc.contains(0.5, 0.5));
        harness.check(!arc.contains(0.5, -0.5));
        arc = new Arc2D.Double();
        harness.check(!arc.contains(0.0, 0.0, 0.0, 0.0));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 1);
        harness.check(!arc.contains(0.45, -0.55, 0.1, 0.1));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 2);
        harness.check(arc.contains(0.45, -0.55, 0.1, 0.1));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 0);
        harness.check(!arc.contains(0.45, -0.55, 0.1, 0.1));
        arc = new Arc2D.Double();
        harness.check(!arc.contains(new Rectangle2D.Double(0.0, 0.0, 0.0, 0.0)));
        Rectangle2D.Double r = new Rectangle2D.Double(0.45, -0.55, 0.1, 0.1);
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 1);
        harness.check(!arc.contains(r));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 2);
        harness.check(arc.contains(r));
        arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 0);
        harness.check(!arc.contains(r));
        boolean pass = false;
        try {
            arc.contains((Rectangle2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

