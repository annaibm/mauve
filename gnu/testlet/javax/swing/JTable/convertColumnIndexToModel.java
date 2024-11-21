/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class convertColumnIndexToModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("convertColumnIndexToModel()");
        DefaultTableModel m1 = new DefaultTableModel(4, 6);
        JTable t = new JTable(m1);
        harness.check(t.convertColumnIndexToModel(0), 0);
        harness.check(t.convertColumnIndexToModel(-1), -1);
        boolean pass = false;
        try {
            t.convertColumnIndexToModel(6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t.convertColumnIndexToModel(999);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        TableColumnModel tcm = t.getColumnModel();
        tcm.moveColumn(0, 4);
        harness.check(t.convertColumnIndexToModel(0), 1);
        harness.check(t.convertColumnIndexToModel(1), 2);
        harness.check(t.convertColumnIndexToModel(2), 3);
        harness.check(t.convertColumnIndexToModel(3), 4);
        harness.check(t.convertColumnIndexToModel(4), 0);
        harness.check(t.convertColumnIndexToModel(5), 5);
    }
}

