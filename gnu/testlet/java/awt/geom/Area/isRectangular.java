/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class isRectangular
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area();
        harness.check(area.isRectangular());
        area = new Area(new Ellipse2D.Double());
        harness.check(area.isRectangular());
        area.add(new Area(new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0)));
        harness.check(area.isRectangular());
        area.add(new Area(new Rectangle2D.Double(10.0, 10.0, 1.0, 1.0)));
        harness.check(!area.isRectangular());
        area = new Area(new Ellipse2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(!area.isRectangular());
    }
}

