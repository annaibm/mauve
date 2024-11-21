/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.Rectangle;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r = new Rectangle();
        r.add(5, 7);
        harness.check(r.x == 0);
        harness.check(r.y == 0);
        harness.check(r.width == 5);
        harness.check(r.height == 7);
        boolean pass = false;
        try {
            r.add((Point)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            r.add((Rectangle)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

