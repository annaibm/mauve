/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.AbstractTableModel.MyTableModel;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;

public class fireTableStructureChanged
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTableModelListener listener = new MyTableModelListener();
        MyTableModel m = new MyTableModel();
        m.addTableModelListener(listener);
        m.fireTableStructureChanged();
        TableModelEvent e = listener.getEvent();
        harness.check(e.getFirstRow(), -1);
        harness.check(e.getLastRow(), -1);
        harness.check(e.getColumn(), -1);
        harness.check(e.getType(), 0);
    }
}

