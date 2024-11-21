/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable.AccessibleJTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JTable.AccessibleJTable.AccessibleJTableCell.MyBooleanTableCellRenderer;
import java.util.Date;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleTable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class getAccessibleColumnHeader
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel tm = new DefaultTableModel(1, 3);
        tm.setValueAt("A", 0, 0);
        tm.setValueAt(new Date(0L), 0, 1);
        tm.setValueAt(Boolean.TRUE, 0, 2);
        JTable table2 = new JTable(tm);
        table2.getColumnModel().getColumn(2).setHeaderRenderer(new MyBooleanTableCellRenderer());
        AccessibleContext tableac = table2.getAccessibleContext();
        harness.check(tableac.getClass().getName().endsWith("AccessibleJTable"));
        AccessibleTable ah = tableac.getAccessibleTable().getAccessibleColumnHeader();
        this.testGetAccessibleRole(harness, ah);
    }

    public void testGetAccessibleRole(TestHarness harness, AccessibleTable at) {
        harness.check(at.getAccessibleAt(0, 0).getAccessibleContext().getAccessibleRole(), AccessibleRole.LABEL);
        harness.check(at.getAccessibleAt(0, 1).getAccessibleContext().getAccessibleRole(), AccessibleRole.LABEL);
        harness.check(at.getAccessibleAt(0, 2).getAccessibleContext().getAccessibleRole(), AccessibleRole.CHECK_BOX);
    }
}

