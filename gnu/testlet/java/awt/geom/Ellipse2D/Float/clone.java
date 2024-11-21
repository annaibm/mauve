/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Ellipse2D.Float e1 = new Ellipse2D.Float(1.0f, 2.0f, 3.0f, 4.0f);
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

