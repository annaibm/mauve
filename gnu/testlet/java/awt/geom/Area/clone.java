/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Area;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Area area1 = new Area();
        Area area2 = (Area)area1.clone();
        harness.check(area1.equals(area2));
        harness.check(area1 != area2);
        area1 = new Area(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        area2 = (Area)area1.clone();
        harness.check(area1.equals(area2));
        harness.check(area1 != area2);
        area1 = new Area(new Rectangle2D.Float(1.0f, 2.0f, 3.0f, 4.0f));
        area2 = (Area)area1.clone();
        harness.check(area1.equals(area2));
        harness.check(area1 != area2);
    }
}

