/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class intersects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area();
        harness.check(!area.intersects(0.0, 0.0, 0.0, 0.0));
        area.add(new Area(new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0)));
        harness.check(!area.intersects(0.0, 0.0, 1.0, 1.0));
        harness.check(!area.intersects(1.0, 0.0, 1.0, 1.0));
        harness.check(!area.intersects(2.0, 0.0, 1.0, 1.0));
        harness.check(!area.intersects(0.0, 1.0, 1.0, 1.0));
        harness.check(area.intersects(1.0, 1.0, 1.0, 1.0));
        harness.check(!area.intersects(2.0, 1.0, 1.0, 1.0));
        harness.check(!area.intersects(0.0, 2.0, 1.0, 1.0));
        harness.check(!area.intersects(1.0, 2.0, 1.0, 1.0));
        harness.check(!area.intersects(2.0, 2.0, 1.0, 1.0));
        area = new Area();
        boolean pass = false;
        try {
            area.intersects(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

