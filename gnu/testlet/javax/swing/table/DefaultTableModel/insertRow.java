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

public class insertRow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testInsertRow1(harness);
        this.testInsertRow2(harness);
    }

    private void testInsertRow1(TestHarness harness) {
        harness.checkPoint("insertRow(int, Object[])");
        DefaultTableModel m1 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 0);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.insertRow(0, new Object[]{"V1", "V2", "V3"});
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getRowCount(), 1);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 1);
        listener1.setEvent(null);
        m1.insertRow(0, (Object[])null);
        harness.check(m1.getRowCount(), 2);
        event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 0);
        listener1.setEvent(null);
        boolean pass = false;
        try {
            m1.insertRow(-1, (Object[])null);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.insertRow(999, (Object[])null);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testInsertRow2(TestHarness harness) {
        harness.checkPoint("insertRow(int, Vector)");
        Vector<String> v1 = new Vector<String>();
        v1.add("V1");
        v1.add("V2");
        v1.add("V3");
        DefaultTableModel m1 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 0);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.insertRow(0, v1);
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getRowCount(), 1);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 0);
        listener1.setEvent(null);
        m1.insertRow(0, (Vector)null);
        harness.check(m1.getRowCount(), 2);
        event = listener1.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 0);
        listener1.setEvent(null);
        boolean pass = false;
        try {
            m1.insertRow(-1, (Vector)null);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.insertRow(999, (Vector)null);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

