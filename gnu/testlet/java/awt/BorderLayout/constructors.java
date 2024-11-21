/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        BorderLayout l = new BorderLayout();
        harness.check(l.getHgap(), 0);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int)");
        BorderLayout l = new BorderLayout(1, 2);
        harness.check(l.getHgap(), 1);
        harness.check(l.getVgap(), 2);
        l = new BorderLayout(-1, 2);
        harness.check(l.getHgap(), -1);
        harness.check(l.getVgap(), 2);
        l = new BorderLayout(1, -1);
        harness.check(l.getHgap(), 1);
        harness.check(l.getVgap(), -1);
    }
}

