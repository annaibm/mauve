/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;

public class setRowHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("int");
        JTable t = new JTable(4, 3);
        harness.check(t.getRowHeight(0), 16);
        t.setRowHeight(99);
        harness.check(t.getRowHeight(0), 99);
        t.setRowHeight(1, 13);
        harness.check(t.getRowHeight(1), 13);
        t.setRowHeight(14);
        harness.check(t.getRowHeight(1), 14);
        boolean pass = false;
        try {
            t.setRowHeight(0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(int, int)");
        JTable t = new JTable(4, 3);
        harness.check(t.getRowHeight(0), 16);
        t.setRowHeight(99);
        harness.check(t.getRowHeight(0), 99);
    }
}

