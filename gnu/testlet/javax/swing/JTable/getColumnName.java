/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class getColumnName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        tm.setColumnIdentifiers(new String[]{"C1", "C2", "C3"});
        JTable table2 = new JTable(tm);
        TableColumnModel tcm = table2.getColumnModel();
        TableColumn c0 = tcm.getColumn(0);
        TableColumn c1 = tcm.getColumn(1);
        c0.setModelIndex(1);
        c1.setModelIndex(0);
        harness.check(table2.getColumnName(0), (Object)"C2");
        harness.check(table2.getColumnName(1), (Object)"C1");
        harness.check(table2.getColumnName(2), (Object)"C3");
        c0.setHeaderValue("XX");
        harness.check(table2.getColumnName(0), (Object)"C2");
        c0.setIdentifier("XXX");
        harness.check(table2.getColumnName(0), (Object)"C2");
        boolean pass = false;
        try {
            table2.getColumnName(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            table2.getColumnName(3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

