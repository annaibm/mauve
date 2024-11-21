/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;

public class setArcByTangent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        arc.setArcByTangent(new Point2D.Double(10.0, 0.0), new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 10.0), 1.0);
        harness.check(((Arc2D)arc).getAngleStart(), 90.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 90.0);
        harness.checkPoint("Null arguments");
        this.testNullArguments(harness);
    }

    private void testNullArguments(TestHarness harness) {
        boolean pass = false;
        Arc2D.Double arc = new Arc2D.Double();
        try {
            arc.setArcByTangent(null, new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 10.0), 1.0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            arc.setArcByTangent(new Point2D.Double(10.0, 0.0), null, new Point2D.Double(0.0, 10.0), 1.0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            arc.setArcByTangent(new Point2D.Double(10.0, 0.0), new Point2D.Double(0.0, 10.0), null, 1.0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

