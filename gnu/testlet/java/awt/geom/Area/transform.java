/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class transform
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0));
        area.transform(AffineTransform.getScaleInstance(2.0, 2.0));
        Rectangle2D bounds = area.getBounds2D();
        harness.check(bounds.getX(), 0.0);
        harness.check(bounds.getY(), 0.0);
        harness.check(bounds.getWidth(), 2.0);
        harness.check(bounds.getHeight(), 2.0);
        boolean pass = false;
        try {
            area.transform(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

