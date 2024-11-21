/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class setRect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        r1.setRect(5.0, 6.0, 7.0, 8.0);
        harness.check(r1.x == 5);
        harness.check(r1.y == 6);
        harness.check(r1.width == 7);
        harness.check(r1.height == 8);
        r1.setRect(5.9, 6.9, 7.0, 8.0);
        harness.check(r1.x, 5);
        harness.check(r1.y, 6);
        harness.check(r1.width, 8);
        harness.check(r1.height, 9);
        r1.setRect(-0.1, -0.2, 0.3, 0.4);
        harness.check(r1.x, -1);
        harness.check(r1.y, -1);
        harness.check(r1.width, 2);
        harness.check(r1.height, 2);
        r1.setRect(1.0, 2.0, -3.0, 4.0);
        harness.check(r1.width, -3);
        harness.check(r1.isEmpty());
        r1.setRect(1.0, 2.0, 3.0, -4.0);
        harness.check(r1.height, -4);
        harness.check(r1.isEmpty());
    }
}

