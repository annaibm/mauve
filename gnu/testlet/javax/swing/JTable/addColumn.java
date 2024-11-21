/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class addColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTable table2 = new JTable();
        TableColumn c = new TableColumn();
        table2.addColumn(c);
        TableColumnModel tcm = table2.getColumnModel();
        harness.check(tcm.getColumnCount(), 1);
        boolean pass = false;
        try {
            table2.addColumn(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

