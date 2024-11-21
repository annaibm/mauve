/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Point;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
    }

    private void testConstructor1(TestHarness harness) {
        Point p = new Point();
        harness.check(p.x, 0);
        harness.check(p.y, 0);
    }

    private void testConstructor2(TestHarness harness) {
        Point p = new Point(1, 2);
        harness.check(p.x, 1);
        harness.check(p.y, 2);
    }

    private void testConstructor3(TestHarness harness) {
        Point p = new Point(new Point(2, 3));
        harness.check(p.x, 2);
        harness.check(p.y, 3);
        try {
            p = new Point(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

