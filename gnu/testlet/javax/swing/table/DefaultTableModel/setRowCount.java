/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class setRowCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBasics(harness);
        this.testEvents(harness);
    }

    public void testBasics(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 3);
        m1.setValueAt("V1", 0, 0);
        m1.setValueAt("V2", 1, 0);
        m1.setValueAt("V3", 2, 0);
        m1.setRowCount(4);
        harness.check(m1.getRowCount(), 4);
        harness.check(m1.getValueAt(3, 0), null);
        DefaultTableModel m2 = new DefaultTableModel(3, 1);
        m2.setValueAt("V1", 0, 0);
        m2.setValueAt("V2", 1, 0);
        m2.setValueAt("V3", 2, 0);
        m2.setRowCount(4);
        harness.check(m2.getRowCount(), 4);
        harness.check(m2.getValueAt(0, 0), (Object)"V1");
        DefaultTableModel m3 = new DefaultTableModel();
        boolean pass = false;
        try {
            m3.setRowCount(-1);
        }
        catch (RuntimeException e) {
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
        m1.setRowCount(5);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 3);
        harness.check(event.getLastRow(), 4);
        DefaultTableModel m2 = new DefaultTableModel(3, 1);
        MyTableModelListener listener2 = new MyTableModelListener();
        m2.addTableModelListener(listener2);
        m2.setValueAt("V1", 0, 0);
        m2.setValueAt("V2", 1, 0);
        m2.setValueAt("V3", 2, 0);
        m2.setRowCount(1);
        TableModelEvent event2 = listener2.getEvent();
        harness.check(event2.getType(), -1);
        harness.check(event2.getColumn(), -1);
        harness.check(event2.getFirstRow(), 1);
        harness.check(event2.getLastRow(), 2);
    }
}

