/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.AbstractTableModel.MyTableModel;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;

public class fireTableCellUpdated
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTableModelListener listener = new MyTableModelListener();
        MyTableModel m = new MyTableModel();
        m.addTableModelListener(listener);
        m.fireTableCellUpdated(2, 3);
        TableModelEvent e = listener.getEvent();
        harness.check(e.getFirstRow(), 2);
        harness.check(e.getLastRow(), 2);
        harness.check(e.getColumn(), 3);
        harness.check(e.getSource(), m);
        harness.check(e.getType(), 0);
    }
}

