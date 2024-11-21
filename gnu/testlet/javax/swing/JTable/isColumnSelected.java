/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class isColumnSelected
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testColumnSelectionAllowed(harness);
        this.testColumnSelectionNotAllowed(harness);
    }

    private void testColumnSelectionAllowed(TestHarness harness) {
        JTable table2 = this.createTestTable();
        table2.setColumnSelectionAllowed(true);
        ListSelectionModel selModel = table2.getColumnModel().getSelectionModel();
        selModel.setSelectionInterval(1, 1);
        harness.check(table2.isColumnSelected(1), true);
    }

    private void testColumnSelectionNotAllowed(TestHarness harness) {
        JTable table2 = this.createTestTable();
        table2.setColumnSelectionAllowed(false);
        ListSelectionModel selModel = table2.getColumnModel().getSelectionModel();
        selModel.setSelectionInterval(1, 1);
        harness.check(table2.isColumnSelected(1), true);
    }

    private JTable createTestTable() {
        return new JTable(new Object[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}}, new Object[]{"1", "2", "3"});
    }
}

