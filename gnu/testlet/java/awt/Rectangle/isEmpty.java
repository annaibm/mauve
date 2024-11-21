/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r = new Rectangle();
        harness.check(r.isEmpty());
        r = new Rectangle(0, 0, 100, 0);
        harness.check(r.isEmpty());
        r = new Rectangle(0, 0, 0, 100);
        harness.check(r.isEmpty());
        r = new Rectangle(0, 0, -10, -10);
        harness.check(r.isEmpty());
        r = new Rectangle(0, 0, 1, 1);
        harness.check(!r.isEmpty());
    }
}

