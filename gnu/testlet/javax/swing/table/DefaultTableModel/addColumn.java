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

public class addColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testAddColumn1(harness);
        this.testAddColumn2(harness);
        this.testAddColumn3(harness);
    }

    private void testAddColumn1(TestHarness harness) {
        harness.checkPoint("addColumn(Object)");
        DefaultTableModel m1 = new DefaultTableModel();
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.addColumn("C1");
        harness.check(m1.getColumnCount(), 1);
        harness.check(m1.getColumnName(0), (Object)"C1");
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
        boolean pass = true;
        try {
            m1.addColumn(null);
        }
        catch (IllegalArgumentException e) {
            pass = false;
        }
        harness.check(pass);
    }

    private void testAddColumn2(TestHarness harness) {
        harness.checkPoint("addColumn(Object, Vector)");
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        Vector<String> columnData1 = new Vector<String>();
        columnData1.add("V1");
        columnData1.add("V2");
        m1.addColumn((Object)"C4", columnData1);
        harness.check(m1.getColumnCount(), 4);
        harness.check(m1.getColumnName(3), (Object)"C4");
        harness.check(m1.getValueAt(0, 3), (Object)"V1");
        harness.check(m1.getValueAt(1, 3), (Object)"V2");
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
        DefaultTableModel m2 = new DefaultTableModel(2, 3);
        MyTableModelListener listener2 = new MyTableModelListener();
        m2.addTableModelListener(listener2);
        Vector<String> columnData2 = new Vector<String>();
        columnData2.add("V1");
        m2.addColumn((Object)"C4", columnData2);
        harness.check(m2.getColumnCount(), 4);
        harness.check(m2.getColumnName(3), (Object)"C4");
        harness.check(m2.getValueAt(0, 3), (Object)"V1");
        harness.check(m2.getValueAt(1, 3), null);
        event = listener2.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
        DefaultTableModel m3 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 2);
        Vector<String> columnData3 = new Vector<String>();
        columnData3.add("V1");
        columnData3.add("V2");
        columnData3.add("V3");
        m3.addColumn((Object)"C4", columnData3);
        harness.check(m3.getColumnCount(), 4);
        harness.check(m3.getColumnName(3), (Object)"C4");
        harness.check(m3.getValueAt(0, 3), (Object)"V1");
        harness.check(m3.getValueAt(1, 3), (Object)"V2");
        harness.check(m3.getValueAt(2, 3), (Object)"V3");
        harness.check(m3.getValueAt(2, 2), null);
        boolean pass = true;
        try {
            m1.addColumn(null, new Vector());
        }
        catch (RuntimeException e) {
            pass = false;
        }
        harness.check(pass);
        DefaultTableModel m4 = new DefaultTableModel();
        m4.addColumn((Object)"C1", (Vector)null);
        harness.check(m4.getColumnName(0), (Object)"C1");
        harness.check(m4.getRowCount(), 0);
    }

    private void testAddColumn3(TestHarness harness) {
        harness.checkPoint("addColumn(Object, Object[])");
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        Object[] columnData1 = new Object[]{"V1", "V2"};
        m1.addColumn((Object)"C4", columnData1);
        harness.check(m1.getColumnCount(), 4);
        harness.check(m1.getColumnName(3), (Object)"C4");
        harness.check(m1.getValueAt(0, 3), (Object)"V1");
        harness.check(m1.getValueAt(1, 3), (Object)"V2");
        DefaultTableModel m2 = new DefaultTableModel(2, 3);
        Object[] columnData2 = new Object[]{"V1"};
        m2.addColumn((Object)"C4", columnData2);
        harness.check(m2.getColumnCount(), 4);
        harness.check(m2.getColumnName(3), (Object)"C4");
        harness.check(m2.getValueAt(0, 3), (Object)"V1");
        harness.check(m2.getValueAt(1, 3), null);
        DefaultTableModel m3 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 2);
        Object[] columnData3 = new Object[]{"V1", "V2", "V3"};
        m3.addColumn((Object)"C4", columnData3);
        harness.check(m3.getColumnCount(), 4);
        harness.check(m3.getColumnName(3), (Object)"C4");
        harness.check(m3.getValueAt(0, 3), (Object)"V1");
        harness.check(m3.getValueAt(1, 3), (Object)"V2");
        harness.check(m3.getValueAt(2, 3), (Object)"V3");
        harness.check(m3.getValueAt(2, 2), null);
        boolean pass = true;
        try {
            m1.addColumn(null, new Vector());
        }
        catch (RuntimeException e) {
            pass = false;
        }
        harness.check(pass);
        DefaultTableModel m4 = new DefaultTableModel();
        m4.addColumn((Object)"C1", (Object[])null);
        harness.check(m4.getColumnName(0), (Object)"C1");
        harness.check(m4.getRowCount(), 0);
    }
}

