/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class outcode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r = new Rectangle(0, 0, 10, 10);
        harness.check(r.outcode(5.0, 5.0) == 0);
        harness.check(r.outcode(0.0, 0.0) == 0);
        harness.check(r.outcode(0.0, 10.0) == 0);
        harness.check(r.outcode(10.0, 0.0) == 0);
        harness.check(r.outcode(10.0, 10.0) == 0);
        harness.check(r.outcode(-5.0, 5.0) == 1);
        harness.check(r.outcode(15.0, 5.0) == 4);
        harness.check(r.outcode(5.0, -5.0) == 2);
        harness.check(r.outcode(5.0, 15.0) == 8);
        harness.check(r.outcode(-5.0, -5.0) == 3);
        harness.check(r.outcode(15.0, -5.0) == 6);
        harness.check(r.outcode(15.0, 15.0) == 12);
        harness.check(r.outcode(-5.0, 15.0) == 9);
        r = new Rectangle(0, 0, 0, 0);
        int outside = 15;
        harness.check(r.outcode(-1.0, -1.0) == outside);
        harness.check(r.outcode(-1.0, 0.0) == outside);
        harness.check(r.outcode(-1.0, 1.0) == outside);
        harness.check(r.outcode(0.0, -1.0) == outside);
        harness.check(r.outcode(0.0, 0.0) == outside);
        harness.check(r.outcode(0.0, 1.0) == outside);
        harness.check(r.outcode(1.0, -1.0) == outside);
        harness.check(r.outcode(1.0, 0.0) == outside);
        harness.check(r.outcode(1.0, 1.0) == outside);
        r = new Rectangle(0, 0, -10, -10);
        harness.check(r.outcode(-1.0, -1.0) == outside);
        harness.check(r.outcode(-1.0, 0.0) == outside);
        harness.check(r.outcode(-1.0, 1.0) == outside);
        harness.check(r.outcode(0.0, -1.0) == outside);
        harness.check(r.outcode(0.0, 0.0) == outside);
        harness.check(r.outcode(0.0, 1.0) == outside);
        harness.check(r.outcode(1.0, -1.0) == outside);
        harness.check(r.outcode(1.0, 0.0) == outside);
        harness.check(r.outcode(1.0, 1.0) == outside);
    }
}

