/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class getHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Ellipse2D.Double e = new Ellipse2D.Double();
        harness.check(((RectangularShape)e).getHeight(), 0.0);
        e = new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(((RectangularShape)e).getHeight(), 4.0);
    }
}

