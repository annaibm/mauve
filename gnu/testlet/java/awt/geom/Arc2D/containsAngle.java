/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class containsAngle
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        harness.check(!arc.containsAngle(0.0));
        arc = new Arc2D.Double(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), 90.0, 90.0, 2);
        harness.check(!arc.containsAngle(0.0));
        harness.check(!arc.containsAngle(45.0));
        harness.check(arc.containsAngle(90.0));
        harness.check(arc.containsAngle(135.0));
        harness.check(!arc.containsAngle(180.0));
        harness.check(!arc.containsAngle(225.0));
    }
}

