/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.AbstractTableModel.MyTableModel;

public class isCellEditable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTableModel m1 = new MyTableModel();
        harness.check(m1.isCellEditable(0, 0), false);
        harness.check(m1.isCellEditable(Integer.MIN_VALUE, 0), false);
        harness.check(m1.isCellEditable(Integer.MAX_VALUE, 0), false);
        harness.check(m1.isCellEditable(Integer.MIN_VALUE, Integer.MIN_VALUE), false);
        harness.check(m1.isCellEditable(Integer.MAX_VALUE, Integer.MIN_VALUE), false);
        harness.check(m1.isCellEditable(Integer.MIN_VALUE, Integer.MAX_VALUE), false);
        harness.check(m1.isCellEditable(Integer.MAX_VALUE, Integer.MAX_VALUE), false);
    }
}

