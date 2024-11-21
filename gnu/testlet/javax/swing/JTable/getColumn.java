/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class getColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        tm.setColumnIdentifiers(new String[]{"C1", "C2", "C3"});
        JTable table2 = new JTable(tm);
        TableColumnModel tcm = table2.getColumnModel();
        tcm.getColumn(0).setIdentifier(new Integer(0));
        tcm.getColumn(1).setIdentifier(new Integer(1));
        tcm.getColumn(2).setIdentifier(new Integer(2));
        harness.check(table2.getColumn(new Integer(0)).getHeaderValue(), (Object)"C1");
        harness.check(table2.getColumn(new Integer(1)).getHeaderValue(), (Object)"C2");
        harness.check(table2.getColumn(new Integer(2)).getHeaderValue(), (Object)"C3");
        boolean pass = false;
        try {
            table2.getColumn("XXX");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            table2.getColumn(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

