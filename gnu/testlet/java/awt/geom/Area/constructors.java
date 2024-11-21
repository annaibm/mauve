/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area();
        harness.check(area.isEmpty());
        harness.check(area.isSingular());
        harness.check(area.isPolygonal());
        harness.check(area.isRectangular());
        area = new Area(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(!area.isEmpty());
        harness.check(area.isPolygonal());
        harness.check(area.isRectangular());
        harness.check(area.isSingular());
        boolean pass = false;
        try {
            area = new Area(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

