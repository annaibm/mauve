/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class addRow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testAddRow1(harness);
        this.testAddRow2(harness);
    }

    private void testAddRow1(TestHarness harness) {
        harness.checkPoint("addRow(Object[])");
        DefaultTableModel m1 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 0);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.addRow(new Object[]{"V1", "V2", "V3"});
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getRowCount(), 1);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 0);
        listener1.setEvent(null);
        m1.addRow((Object[])null);
        harness.check(m1.getRowCount(), 2);
        event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 1);
        harness.check(event.getLastRow(), 1);
        listener1.setEvent(null);
    }

    private void testAddRow2(TestHarness harness) {
        harness.checkPoint("addRow(Vector)");
        DefaultTableModel m1 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 0);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        Vector<String> row = new Vector<String>();
        row.add("V1");
        row.add("V2");
        row.add("V3");
        m1.addRow(row);
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getRowCount(), 1);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 0);
        listener1.setEvent(null);
        m1.addRow((Vector)null);
        harness.check(m1.getRowCount(), 2);
        event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 1);
        harness.check(event.getLastRow(), 1);
        listener1.setEvent(null);
    }
}

