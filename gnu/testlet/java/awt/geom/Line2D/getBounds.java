/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class getBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        Rectangle bounds = line1.getBounds();
        harness.check((int)bounds.getX() == 1);
        harness.check((int)bounds.getMaxX() == 3);
        harness.check((int)bounds.getY() == 2);
        harness.check((int)bounds.getMaxY() == 4);
    }
}

