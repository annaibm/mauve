/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.JTableHeader.AccessibleJTableHeader.AccessibleJTableHeaderEntry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class setAccessibleName
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        DefaultTableModel tm = new DefaultTableModel(new String[]{"AA", "BB", "CC"}, 3);
        JTable t = new JTable(tm);
        JTableHeader th = t.getTableHeader();
        AccessibleContext ac = th.getAccessibleContext();
        Accessible ac0 = ac.getAccessibleChild(0);
        harness.check(ac0.getClass().getName().endsWith("AccessibleJTableHeaderEntry"));
        AccessibleContext ac0ac = ac0.getAccessibleContext();
        harness.check(ac0ac.getAccessibleName(), (Object)"AA");
        ac0ac.addPropertyChangeListener(this);
        ac0ac.setAccessibleName("AAx");
        harness.check(ac0ac.getAccessibleName(), (Object)"AAx");
        harness.check(this.events.size(), 1);
        PropertyChangeEvent pce = (PropertyChangeEvent)this.events.get(0);
        harness.check(pce.getPropertyName(), (Object)"AccessibleName");
        harness.check(pce.getOldValue(), null);
        harness.check(pce.getNewValue(), (Object)"AAx");
    }
}

