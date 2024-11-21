/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class grow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r = new Rectangle(0, 0, 0, 0);
        r.grow(5, 7);
        harness.check(r.x == -5);
        harness.check(r.y == -7);
        harness.check(r.width == 10);
        harness.check(r.height == 14);
    }
}

