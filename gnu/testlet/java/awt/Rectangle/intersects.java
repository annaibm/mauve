/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class intersects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r0 = new Rectangle(0, 0, 0, 0);
        Rectangle r1 = new Rectangle(0, 0, 1, 1);
        Rectangle r2 = new Rectangle(1, 1, 1, 1);
        Rectangle r3 = new Rectangle(-1, -1, 1, 1);
        Rectangle r4 = new Rectangle(-1, -1, 2, 2);
        Rectangle r5 = new Rectangle(-1, -1, 3, 3);
        harness.check(!r0.intersects(r1));
        harness.check(!r0.intersects(r2));
        harness.check(!r1.intersects(r2));
        harness.check(!r2.intersects(r3));
        harness.check(!r2.intersects(r4));
        harness.check(r2.intersects(r5));
        boolean pass = false;
        try {
            r0.intersects(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

