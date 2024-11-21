/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import java.beans.PropertyChangeListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class addColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        TableColumn c1 = new TableColumn(1, 23);
        m1.addColumn(c1);
        harness.check(m1.getColumnCount(), 1);
        PropertyChangeListener[] listeners = c1.getPropertyChangeListeners();
        harness.check(listeners[0], m1);
        TableColumn c = m1.getColumn(0);
        harness.check(c.getWidth(), 23);
        boolean pass = false;
        try {
            m1.addColumn(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        m1.addColumn(new TableColumn(2, 45));
        harness.check(listener.getEvent() != null);
        harness.check(listener.getEvent().getFromIndex(), 0);
        harness.check(listener.getEvent().getToIndex(), 1);
    }
}

