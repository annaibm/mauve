/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.Rectangle;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r = new Rectangle();
        harness.check(!r.contains(0, 0));
        harness.check(!r.contains(1, 1));
        r = new Rectangle(0, 0, -10, -10);
        harness.check(!r.contains(-5, -5));
        harness.check(!r.contains(0, 0));
        r = new Rectangle(0, 0, 10, 10);
        harness.check(r.contains(0, 0, 10, 10));
        harness.check(!r.contains(10, 10));
        boolean pass = false;
        try {
            r.contains((Point)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            r.contains((Rectangle)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

