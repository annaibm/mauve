/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;

public class setAngleStart
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double(0.0, 0.0, 1.0, 1.0, 0.0, 90.0, 2);
        ((Arc2D)arc).setAngleStart(85.0);
        harness.check(((Arc2D)arc).getAngleStart(), 85.0);
        arc.setAngleStart(new Point2D.Double(1.0, 1.0));
        harness.check(((Arc2D)arc).getAngleStart(), -45.0);
        boolean pass = false;
        try {
            arc.setAngleStart(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

