/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;

public class getRowHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("()");
        JTable t = new JTable(4, 3);
        harness.check(t.getRowHeight(), 16);
        t.setRowHeight(99);
        harness.check(t.getRowHeight(), 99);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(int)");
        JTable t = new JTable(4, 3);
        harness.check(t.getRowHeight(0), 16);
        t.setRowHeight(99);
        harness.check(t.getRowHeight(0), 99);
        t.setRowHeight(0, 12);
        harness.check(t.getRowHeight(0), 12);
        harness.check(t.getRowHeight(-1), 0);
        harness.check(t.getRowHeight(4), 0);
    }
}

