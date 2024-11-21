/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Point;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;

public class getLocation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Point p = new Point(1, 2);
        Point l = p.getLocation();
        harness.check(l.x, 1);
        harness.check(l.y, 2);
        p.setLocation(4, 5);
        harness.check(l.x, 1);
        harness.check(l.y, 2);
    }
}

