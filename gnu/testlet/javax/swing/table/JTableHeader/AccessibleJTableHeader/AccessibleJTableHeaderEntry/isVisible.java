/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.JTableHeader.AccessibleJTableHeader.AccessibleJTableHeaderEntry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.JTableHeader.AccessibleJTableHeader.AccessibleJTableHeaderEntry.MyTableCellRenderer;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class isVisible
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel tm = new DefaultTableModel(new String[]{"AA", "BB", "CC"}, 3);
        JTable t = new JTable(tm);
        JTableHeader th = t.getTableHeader();
        AccessibleContext ac = th.getAccessibleContext();
        Accessible ac0 = ac.getAccessibleChild(0);
        harness.check(ac0.getClass().getName().endsWith("AccessibleJTableHeaderEntry"));
        AccessibleComponent ac0ac = ac0.getAccessibleContext().getAccessibleComponent();
        harness.check(ac0ac.isVisible(), true);
        MyTableCellRenderer r = new MyTableCellRenderer();
        r.setVisible(false);
        t.getColumnModel().getColumn(1).setHeaderRenderer(r);
        Accessible ac1 = ac.getAccessibleChild(1);
        harness.check(ac1.getClass().getName().endsWith("AccessibleJTableHeaderEntry"));
        AccessibleComponent ac1ac = ac1.getAccessibleContext().getAccessibleComponent();
        harness.check(ac1ac.isVisible(), false);
    }
}

