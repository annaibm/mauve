/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.AbstractTableModel.MyTableModel;

public class getColumnClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTableModel m1 = new MyTableModel();
        harness.check(m1.getColumnClass(0), Object.class);
        harness.check(m1.getColumnClass(Integer.MIN_VALUE), Object.class);
        harness.check(m1.getColumnClass(Integer.MAX_VALUE), Object.class);
    }
}

