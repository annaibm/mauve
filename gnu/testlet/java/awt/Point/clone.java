/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Point;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Point p1 = new Point(10, 11);
        Point p2 = null;
        p2 = (Point)p1.clone();
        harness.check(p1.equals(p2));
        harness.check(p1 != p2);
    }
}

