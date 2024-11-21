/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;

public class setAngles
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double(-1.0, -1.0, 2.0, 2.0, 0.0, 90.0, 2);
        arc.setAngles(1.0, -1.0, -1.0, -1.0);
        harness.check(((Arc2D)arc).getAngleStart(), 45.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 90.0);
        arc.setAngles(new Point2D.Double(1.0, 1.0), new Point2D.Double(-1.0, 1.0));
        harness.check(((Arc2D)arc).getAngleStart(), -45.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 270.0);
        boolean pass = false;
        try {
            arc.setAngles(null, new Point2D.Double(-1.0, 1.0));
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            arc.setAngles(new Point2D.Double(-1.0, 1.0), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

