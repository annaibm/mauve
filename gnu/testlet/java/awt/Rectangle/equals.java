/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r0 = new Rectangle(0, 0, 0, 0);
        Rectangle r1 = new Rectangle(0, 0, 0, 0);
        harness.check(r0.equals(r1));
        harness.check(r1.equals(r0));
        r0.x = 1;
        harness.check(!r0.equals(r1));
        r1.x = 1;
        harness.check(r0.equals(r1));
        r0.y = 2;
        harness.check(!r0.equals(r1));
        r1.y = 2;
        harness.check(r0.equals(r1));
        r0.width = 3;
        harness.check(!r0.equals(r1));
        r1.width = 3;
        harness.check(r0.equals(r1));
        r0.height = 4;
        harness.check(!r0.equals(r1));
        r1.height = 4;
        harness.check(r0.equals(r1));
    }
}

