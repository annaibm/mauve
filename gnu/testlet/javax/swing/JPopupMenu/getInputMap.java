/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JPopupMenu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JPopupMenu;

public class getInputMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        JPopupMenu p = new JPopupMenu();
        InputMap m1 = p.getInputMap();
        InputMap m2 = p.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JPopupMenu p = new JPopupMenu();
        InputMap m1 = p.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p, null);
        InputMap m2 = p.getInputMap(1);
        harness.check(m2.keys(), null);
        harness.check(m2.getParent(), null);
        InputMap m3 = p.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

