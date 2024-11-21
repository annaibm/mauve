/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class union
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        Rectangle r2 = new Rectangle(5, 6, 7, 8);
        Rectangle r3 = r1.union(r2);
        harness.check(r3.x == 1);
        harness.check(r3.y == 2);
        harness.check(r3.width == 11);
        harness.check(r3.height == 12);
        r1 = new Rectangle();
        r2 = new Rectangle(1, 2, 3, 4);
        r3 = r1.union(r2);
        harness.check(r3.x == 0);
        harness.check(r3.y == 0);
        harness.check(r3.width == 4);
        harness.check(r3.height == 6);
        boolean pass = false;
        try {
            r3 = r1.union(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

