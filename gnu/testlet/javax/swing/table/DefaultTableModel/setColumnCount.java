/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class setColumnCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBasics(harness);
        this.testEvents(harness);
    }

    public void testBasics(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(1, 3);
        m1.setValueAt("V1", 0, 0);
        m1.setValueAt("V2", 0, 1);
        m1.setValueAt("V3", 0, 2);
        m1.setColumnCount(4);
        harness.check(m1.getColumnCount(), 4);
        harness.check(m1.getValueAt(0, 3), null);
        DefaultTableModel m2 = new DefaultTableModel(1, 3);
        m2.setValueAt("V1", 0, 0);
        m2.setValueAt("V2", 0, 1);
        m2.setValueAt("V3", 0, 2);
        m2.setColumnCount(1);
        harness.check(m2.getColumnCount(), 1);
        harness.check(m2.getValueAt(0, 0), (Object)"V1");
        m2.setColumnCount(0);
        harness.check(m2.getColumnCount(), 0);
        DefaultTableModel m3 = new DefaultTableModel();
        boolean pass = false;
        try {
            m3.setColumnCount(-1);
        }
        catch (RuntimeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testEvents(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(1, 3);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.setValueAt("V1", 0, 0);
        m1.setValueAt("V2", 0, 1);
        m1.setValueAt("V3", 0, 2);
        m1.setColumnCount(4);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
        DefaultTableModel m2 = new DefaultTableModel(1, 3);
        MyTableModelListener listener2 = new MyTableModelListener();
        m2.addTableModelListener(listener2);
        m2.setValueAt("V1", 0, 0);
        m2.setValueAt("V2", 0, 1);
        m2.setValueAt("V3", 0, 2);
        m2.setColumnCount(1);
        TableModelEvent event2 = listener2.getEvent();
        harness.check(event2.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
    }
}

