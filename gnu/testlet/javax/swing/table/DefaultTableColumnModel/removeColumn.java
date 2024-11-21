/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class removeColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        TableColumn c0 = new TableColumn(0, 23);
        TableColumn c1 = new TableColumn(1, 34);
        TableColumn c2 = new TableColumn(2, 45);
        m1.addColumn(c0);
        m1.addColumn(c1);
        m1.addColumn(c2);
        m1.removeColumn(c1);
        harness.check(m1.getColumnCount(), 2);
        harness.check(c1.getPropertyChangeListeners().length, 0);
        TableColumn c3 = new TableColumn(3, 99);
        m1.removeColumn(c3);
        harness.check(m1.getColumnCount(), 2);
        m1.removeColumn(null);
        harness.check(m1.getColumnCount(), 2);
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        m1.removeColumn(c0);
        harness.check(listener.getEvent() != null);
        harness.check(listener.getEvent().getFromIndex(), 0);
        harness.check(listener.getEvent().getToIndex(), 0);
    }
}

