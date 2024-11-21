/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area1 = new Area();
        Area area2 = new Area();
        harness.check(area1.equals(area2));
        harness.check(!area1.equals((Object)area2));
        area1 = new Area(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        area2 = new Area(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        harness.check(area1.equals(area2));
        Area area3 = new Area();
        harness.check(!area3.equals(null));
    }
}

