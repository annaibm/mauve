/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Ellipse2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class getWidth
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Ellipse2D.Float e = new Ellipse2D.Float();
        harness.check(((RectangularShape)e).getWidth(), 0.0);
        e = new Ellipse2D.Float(1.0f, 2.0f, 3.0f, 4.0f);
        harness.check(((RectangularShape)e).getWidth(), 3.0);
    }
}

