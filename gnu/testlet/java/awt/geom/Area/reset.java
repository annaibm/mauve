/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class reset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area = new Area();
        area.add(new Area(new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0)));
        harness.check(!area.isEmpty());
        area.reset();
        harness.check(area.isEmpty());
    }
}

