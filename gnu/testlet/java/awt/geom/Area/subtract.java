/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class subtract
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area();
        area.add(new Area(new Rectangle2D.Double(-1.0, -1.0, 2.0, 2.0)));
        area.subtract(new Area(new Rectangle2D.Double(0.0, 0.0, 2.0, 2.0)));
        harness.check(area.contains(-1.0, -1.0));
        harness.check(area.contains(-1.0, 0.0));
        harness.check(!area.contains(-1.0, 1.0));
        harness.check(!area.contains(-1.0, 2.0));
        harness.check(area.contains(0.0, -1.0));
        harness.check(!area.contains(0.0, 0.0));
        harness.check(!area.contains(0.5, 0.5));
        harness.check(!area.contains(0.0, 1.0));
        harness.check(!area.contains(0.0, 2.0));
        harness.check(!area.contains(1.0, -1.0));
        harness.check(!area.contains(1.0, 0.0));
        harness.check(!area.contains(1.0, 1.0));
        harness.check(!area.contains(1.0, 2.0));
        harness.check(!area.contains(2.0, -1.0));
        harness.check(!area.contains(2.0, 0.0));
        harness.check(!area.contains(2.0, 1.0));
        harness.check(!area.contains(2.0, 2.0));
        boolean pass = false;
        try {
            area.subtract(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

