/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class convertColumnIndexToView
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("convertColumnIndexToView()");
        DefaultTableModel m1 = new DefaultTableModel(4, 6);
        JTable t = new JTable(m1);
        harness.check(t.convertColumnIndexToView(0), 0);
        harness.check(t.convertColumnIndexToView(-1), -1);
        harness.check(t.convertColumnIndexToView(6), -1);
        harness.check(t.convertColumnIndexToView(999), -1);
        TableColumnModel tcm = t.getColumnModel();
        tcm.moveColumn(0, 4);
        harness.check(t.convertColumnIndexToView(0), 4);
        harness.check(t.convertColumnIndexToView(1), 0);
        harness.check(t.convertColumnIndexToView(2), 1);
        harness.check(t.convertColumnIndexToView(3), 2);
        harness.check(t.convertColumnIndexToView(4), 3);
        harness.check(t.convertColumnIndexToView(5), 5);
    }
}

