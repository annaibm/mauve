/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        Rectangle r2 = null;
        r2 = (Rectangle)r1.clone();
        harness.check(r1 != r2);
        harness.check(r1.getClass().equals(r2.getClass()));
        harness.check(r1.x == r2.x);
        harness.check(r1.y == r2.y);
        harness.check(r1.width == r2.width);
        harness.check(r1.height == r2.height);
    }
}

