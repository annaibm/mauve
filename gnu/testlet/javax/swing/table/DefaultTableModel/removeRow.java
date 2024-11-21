/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class removeRow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBasics(harness);
        this.testEvents(harness);
    }

    public void testBasics(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(3, 1);
        m1.setValueAt("V1", 0, 0);
        m1.setValueAt("V2", 1, 0);
        m1.setValueAt("V3", 2, 0);
        m1.removeRow(1);
        harness.check(m1.getRowCount(), 2);
        harness.check(m1.getValueAt(0, 0), (Object)"V1");
        harness.check(m1.getValueAt(1, 0), (Object)"V3");
        boolean pass = false;
        try {
            m1.removeRow(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.removeRow(99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testEvents(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(3, 1);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.setValueAt("V1", 0, 0);
        m1.setValueAt("V2", 1, 0);
        m1.setValueAt("V3", 2, 0);
        m1.removeRow(2);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 2);
        harness.check(event.getLastRow(), 2);
        harness.check(event.getType(), -1);
    }
}

