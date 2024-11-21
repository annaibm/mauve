/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class getBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area1 = new Area();
        Rectangle r = area1.getBounds();
        harness.check(r.isEmpty());
        area1 = new Area(new Rectangle2D.Double(0.5, 0.5, 1.0, 1.0));
        r = area1.getBounds();
        harness.check(r.equals(new Rectangle(0, 0, 2, 2)));
    }
}

