/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area();
        harness.check(area.isEmpty());
        area = new Area(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(area.isEmpty());
        area = new Area(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(!area.isEmpty());
    }
}

