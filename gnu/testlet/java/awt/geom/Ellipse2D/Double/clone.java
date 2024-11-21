/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Ellipse2D.Double e1 = new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0);
        Ellipse2D e2 = null;
        e2 = (Ellipse2D)e1.clone();
        harness.check(((RectangularShape)e1).getX(), e2.getX());
        harness.check(((RectangularShape)e1).getY(), e2.getY());
        harness.check(((RectangularShape)e1).getWidth(), e2.getWidth());
        harness.check(((RectangularShape)e1).getHeight(), e2.getHeight());
        harness.check(e1.getClass(), e2.getClass());
        harness.check(e1 != e2);
    }
}

