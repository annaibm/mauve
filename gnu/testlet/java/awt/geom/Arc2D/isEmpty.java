/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.RectangularShape;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        harness.check(((RectangularShape)arc).isEmpty());
        arc = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 1);
        harness.check(!((RectangularShape)arc).isEmpty());
        arc = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 2);
        harness.check(!((RectangularShape)arc).isEmpty());
        arc = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 0);
        harness.check(!((RectangularShape)arc).isEmpty());
    }
}

