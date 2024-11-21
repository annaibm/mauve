/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class setBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        r1.setBounds(5, 6, 7, 8);
        harness.check(r1.x == 5);
        harness.check(r1.y == 6);
        harness.check(r1.width == 7);
        harness.check(r1.height == 8);
        r1 = new Rectangle();
        r1.setBounds(new Rectangle(5, 6, 7, 8));
        harness.check(r1.x == 5);
        harness.check(r1.y == 6);
        harness.check(r1.width == 7);
        harness.check(r1.height == 8);
        boolean pass = false;
        try {
            r1.setBounds(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

