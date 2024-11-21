/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.JTableHeader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class getAccessibleContext
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        JTableHeader th = new JTableHeader();
        AccessibleContext ac = th.getAccessibleContext();
        harness.check(ac.getAccessibleName(), null);
        harness.check(ac.getAccessibleRole(), AccessibleRole.PANEL);
        harness.check(ac.getAccessibleChildrenCount(), 0);
        harness.check(ac.getAccessibleChild(0), null);
        AccessibleComponent acomp = ac.getAccessibleComponent();
        harness.check(acomp.getBackground(), th.getBackground());
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        DefaultTableColumnModel tcm = new DefaultTableColumnModel();
        TableColumn tc0 = new TableColumn(0, 10);
        tc0.setHeaderValue("XYZ0");
        tcm.addColumn(tc0);
        tcm.addColumn(new TableColumn(1, 20));
        tcm.addColumn(new TableColumn(2, 30));
        JTable t = new JTable(tm, tcm);
        JTableHeader th = t.getTableHeader();
        AccessibleContext ac = th.getAccessibleContext();
        harness.check(ac.getAccessibleName(), null);
        harness.check(ac.getAccessibleRole(), AccessibleRole.PANEL);
        harness.check(ac.getAccessibleChildrenCount(), 3);
        AccessibleContext he0 = ac.getAccessibleChild(0).getAccessibleContext();
        harness.check(he0.getAccessibleName(), (Object)"XYZ0");
        harness.check(he0.getAccessibleRole(), AccessibleRole.LABEL);
        harness.check(he0.getAccessibleComponent(), he0);
    }
}

