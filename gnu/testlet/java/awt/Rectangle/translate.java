/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class translate
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        r1.translate(5, 6);
        harness.check(r1.x == 6);
        harness.check(r1.y == 8);
        harness.check(r1.width == 3);
        harness.check(r1.height == 4);
    }
}

