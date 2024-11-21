/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.JTableHeader.AccessibleJTableHeader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class getAccessibleRole
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel tm = new DefaultTableModel(new String[]{"AA", "BB", "CC"}, 3);
        JTable t = new JTable(tm);
        JTableHeader th = t.getTableHeader();
        AccessibleContext ac = th.getAccessibleContext();
        harness.check(ac.getAccessibleRole(), AccessibleRole.PANEL);
    }
}

