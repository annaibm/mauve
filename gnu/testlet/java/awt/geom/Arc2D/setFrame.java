/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.RectangularShape;

public class setFrame
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double(0.0, 0.0, 1.0, 1.0, 0.0, 90.0, 2);
        arc.setFrame(1.0, 2.0, 3.0, 4.0);
        harness.check(((RectangularShape)arc).getX(), 1.0);
        harness.check(((RectangularShape)arc).getY(), 2.0);
        harness.check(((RectangularShape)arc).getWidth(), 3.0);
        harness.check(((RectangularShape)arc).getHeight(), 4.0);
    }
}

