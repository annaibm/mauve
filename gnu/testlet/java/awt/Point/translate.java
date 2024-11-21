/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Point;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;

public class translate
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Point p = new Point(1, 2);
        p.translate(3, 4);
        harness.check(p.x, 4);
        harness.check(p.y, 6);
    }
}

