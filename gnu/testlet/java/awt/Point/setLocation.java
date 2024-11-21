/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Point;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;

public class setLocation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("setLocation(int, int)");
        Point p = new Point();
        p.setLocation(4, 5);
        harness.check(p.x, 4);
        harness.check(p.y, 5);
        harness.checkPoint("setLocation(Point)");
        p.setLocation(new Point(6, 7));
        harness.check(p.x, 6);
        harness.check(p.y, 7);
        try {
            p.setLocation(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        harness.checkPoint("setLocation(double, double)");
        p = new Point();
        p.setLocation(1.2, 2.3);
        harness.check(p.x, 1);
        harness.check(p.y, 2);
        p.setLocation(1.51, 2.7);
        harness.check(p.x, 2);
        harness.check(p.y, 3);
        p.setLocation(1.5, 2.5);
        harness.check(p.x, 2);
        harness.check(p.y, 3);
        p.setLocation(-1.5, -2.5);
        harness.check(p.x, -1);
        harness.check(p.y, -2);
        p.setLocation(1.499, 2.499);
        harness.check(p.x, 1);
        harness.check(p.y, 2);
        p.setLocation(Double.NaN, Double.NaN);
        harness.check(p.x, 0);
        harness.check(p.y, 0);
        double bigPos = 2.147493647E9;
        double bigNeg = -2.147493648E9;
        p.setLocation(bigPos, bigPos);
        harness.check(p.x, Integer.MAX_VALUE);
        harness.check(p.y, Integer.MAX_VALUE);
        p.setLocation(bigNeg, bigNeg);
        harness.check(p.x, Integer.MIN_VALUE);
        harness.check(p.y, Integer.MIN_VALUE);
    }
}

