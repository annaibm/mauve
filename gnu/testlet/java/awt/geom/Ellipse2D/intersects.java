/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;

public class intersects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Ellipse2D.Double e = new Ellipse2D.Double();
        harness.check(!e.intersects(0.0, 0.0, 0.0, 0.0));
        harness.check(!e.intersects(-1.0, -1.0, 2.0, 2.0));
        e = new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(e.intersects(1.0, 2.0, 3.0, 4.0));
        harness.check(!e.intersects(0.0, 0.0, 1.0, 1.0));
    }
}

