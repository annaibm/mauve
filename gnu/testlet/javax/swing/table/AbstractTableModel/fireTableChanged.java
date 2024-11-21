/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.AbstractTableModel.MyTableModel;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;

public class fireTableChanged
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTableModelListener listener = new MyTableModelListener();
        MyTableModel m = new MyTableModel();
        m.addTableModelListener(listener);
        TableModelEvent e1 = new TableModelEvent(m);
        m.fireTableChanged(e1);
        TableModelEvent e2 = listener.getEvent();
        harness.check(e1 == e2);
        m.fireTableChanged(null);
        harness.check(listener.getEvent() == null);
    }
}

