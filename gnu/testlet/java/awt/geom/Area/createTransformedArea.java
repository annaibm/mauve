/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class createTransformedArea
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area1 = new Area();
        Area area2 = area1.createTransformedArea(AffineTransform.getScaleInstance(2.0, 2.0));
        harness.check(area1.isEmpty());
        harness.check(area2.isEmpty());
        harness.check(area1 != area2);
        area1 = new Area(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        AffineTransform at = AffineTransform.getScaleInstance(2.0, 2.0);
        area2 = area1.createTransformedArea(at);
        harness.check(area1 != area2);
        Rectangle2D b1 = area1.getBounds2D();
        Rectangle2D b2 = area2.getBounds2D();
        harness.check(b1.getX() == 1.0);
        harness.check(b1.getY() == 2.0);
        harness.check(b1.getWidth() == 3.0);
        harness.check(b1.getHeight() == 4.0);
        harness.check(b2.getX() == 2.0);
        harness.check(b2.getY() == 4.0);
        harness.check(b2.getWidth() == 6.0);
        harness.check(b2.getHeight() == 8.0);
        boolean pass = false;
        try {
            area2 = area1.createTransformedArea(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

