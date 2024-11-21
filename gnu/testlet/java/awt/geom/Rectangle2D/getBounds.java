/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class getBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Double rect = new Rectangle2D.Double(10.0, 15.0, 20.0, 25.0);
        Rectangle bounds = rect.getBounds();
        harness.check(bounds.getX(), 10.0);
        harness.check(bounds.getY(), 15.0);
        harness.check(bounds.getWidth(), 20.0);
        harness.check(bounds.getHeight(), 25.0);
        rect = new Rectangle2D.Double(12.3, 45.6, 65.8, 32.1);
        bounds = rect.getBounds();
        harness.check(bounds.getX(), 12.0);
        harness.check(bounds.getY(), 45.0);
        harness.check(bounds.getWidth(), 67.0);
        harness.check(bounds.getHeight(), 33.0);
        rect = new Rectangle2D.Double(10.0, 15.0, 20.0, 0.0);
        bounds = rect.getBounds();
        harness.check(bounds.getX(), 10.0);
        harness.check(bounds.getY(), 15.0);
        harness.check(bounds.getWidth(), 20.0);
        harness.check(bounds.getHeight(), 0.0);
    }
}

