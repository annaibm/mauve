/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Rectangle;

public class setSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        r1.setSize(5, 6);
        harness.check(r1.x == 1);
        harness.check(r1.y == 2);
        harness.check(r1.width == 5);
        harness.check(r1.height == 6);
        r1 = new Rectangle(1, 2, 3, 4);
        r1.setSize(new Dimension(5, 6));
        harness.check(r1.x == 1);
        harness.check(r1.y == 2);
        harness.check(r1.width == 5);
        harness.check(r1.height == 6);
        boolean pass = false;
        try {
            r1.setSize(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

