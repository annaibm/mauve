/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class createDefaultColumnsFromModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("Test 1");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        tm.setColumnIdentifiers(new String[]{"C0", "C1", "C2"});
        JTable table2 = new JTable(tm);
        DefaultTableColumnModel tcm1 = new DefaultTableColumnModel();
        tcm1.addColumn(new TableColumn(1, 50));
        table2.setColumnModel(tcm1);
        table2.createDefaultColumnsFromModel();
        TableColumnModel tcm2 = table2.getColumnModel();
        harness.check(tcm1 == tcm2);
        harness.check(tcm2.getColumnCount(), 3);
        TableColumn c0 = tcm2.getColumn(0);
        TableColumn c1 = tcm2.getColumn(1);
        TableColumn c2 = tcm2.getColumn(2);
        harness.check(c0.getIdentifier(), (Object)"C0");
        harness.check(c0.getWidth(), 75);
        harness.check(c0.getMinWidth(), 15);
        harness.check(c0.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c1.getIdentifier(), (Object)"C1");
        harness.check(c1.getWidth(), 75);
        harness.check(c1.getMinWidth(), 15);
        harness.check(c1.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c2.getIdentifier(), (Object)"C2");
        harness.check(c2.getWidth(), 75);
        harness.check(c2.getMinWidth(), 15);
        harness.check(c2.getMaxWidth(), Integer.MAX_VALUE);
    }
}

