/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTableHeader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.table.JTableHeader;

public class getInputMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        JTableHeader th = new JTableHeader();
        InputMap m1 = th.getInputMap();
        InputMap m2 = th.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JTableHeader th = new JTableHeader();
        InputMap m1 = th.getInputMap(0);
        harness.check(m1.keys(), null);
        harness.check(m1.getParent(), null);
        InputMap m2 = th.getInputMap(1);
        harness.check(m2.keys(), null);
        harness.check(m2.getParent(), null);
        InputMap m3 = th.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

