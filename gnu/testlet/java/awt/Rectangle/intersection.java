/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class intersection
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r0 = new Rectangle(0, 0, 0, 0);
        Rectangle r1 = new Rectangle(1, 2, 3, 4);
        Rectangle r2 = new Rectangle(1, 2, 4, 3);
        Rectangle r3 = new Rectangle(10, 10, 0, 0);
        Rectangle r = r0.intersection(r1);
        harness.check(r.isEmpty());
        r = r1.intersection(r2);
        harness.check(r.equals(new Rectangle(1, 2, 3, 3)));
        r = r2.intersection(r3);
        harness.check(r.isEmpty());
        boolean pass = false;
        try {
            r0.intersection(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

