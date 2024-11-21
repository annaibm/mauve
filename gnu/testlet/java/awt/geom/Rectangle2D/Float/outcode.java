/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Rectangle2D.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;

public class outcode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle2D.Float r = new Rectangle2D.Float(0.0f, 0.0f, 10.0f, 10.0f);
        harness.check(((Rectangle2D)r).outcode(5.0, 5.0) == 0);
        harness.check(((Rectangle2D)r).outcode(0.0, 0.0) == 0);
        harness.check(((Rectangle2D)r).outcode(0.0, 10.0) == 0);
        harness.check(((Rectangle2D)r).outcode(10.0, 0.0) == 0);
        harness.check(((Rectangle2D)r).outcode(10.0, 10.0) == 0);
        harness.check(((Rectangle2D)r).outcode(-5.0, 5.0) == 1);
        harness.check(((Rectangle2D)r).outcode(15.0, 5.0) == 4);
        harness.check(((Rectangle2D)r).outcode(5.0, -5.0) == 2);
        harness.check(((Rectangle2D)r).outcode(5.0, 15.0) == 8);
        harness.check(((Rectangle2D)r).outcode(-5.0, -5.0) == 3);
        harness.check(((Rectangle2D)r).outcode(15.0, -5.0) == 6);
        harness.check(((Rectangle2D)r).outcode(15.0, 15.0) == 12);
        harness.check(((Rectangle2D)r).outcode(-5.0, 15.0) == 9);
        r = new Rectangle2D.Float(0.0f, 0.0f, 0.0f, 0.0f);
        int outside = 15;
        harness.check(((Rectangle2D)r).outcode(-1.0, -1.0) == outside);
        harness.check(((Rectangle2D)r).outcode(-1.0, 0.0) == outside);
        harness.check(((Rectangle2D)r).outcode(-1.0, 1.0) == outside);
        harness.check(((Rectangle2D)r).outcode(0.0, -1.0) == outside);
        harness.check(((Rectangle2D)r).outcode(0.0, 0.0) == outside);
        harness.check(((Rectangle2D)r).outcode(0.0, 1.0) == outside);
        harness.check(((Rectangle2D)r).outcode(1.0, -1.0) == outside);
        harness.check(((Rectangle2D)r).outcode(1.0, 0.0) == outside);
        harness.check(((Rectangle2D)r).outcode(1.0, 1.0) == outside);
        boolean pass = false;
        try {
            r.outcode(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

