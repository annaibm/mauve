/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JTable.MyJTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class createDefaultDataModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("createDefaultDataModel()");
        MyJTable t = new MyJTable();
        TableModel m = t.createDefaultDataModel();
        harness.check(m instanceof DefaultTableModel);
        harness.check(m.getColumnCount(), 0);
        harness.check(m.getRowCount(), 0);
    }
}

