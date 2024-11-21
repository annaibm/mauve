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

public class setDataVector
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.testEvent(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("setDataVector(Object[][], Object[])");
        DefaultTableModel m1 = new DefaultTableModel();
        Object[][] data = new Object[2][3];
        data[0][0] = "V1";
        data[0][1] = "V2";
        data[0][2] = "V3";
        data[1][0] = "V4";
        data[1][1] = "V5";
        data[1][2] = "V6";
        Object[] columns = new Object[]{"C1", "C2", "C3"};
        m1.setDataVector(data, columns);
        harness.check(m1.getValueAt(0, 0), (Object)"V1");
        harness.check(m1.getValueAt(0, 1), (Object)"V2");
        harness.check(m1.getValueAt(0, 2), (Object)"V3");
        harness.check(m1.getValueAt(1, 0), (Object)"V4");
        harness.check(m1.getValueAt(1, 1), (Object)"V5");
        harness.check(m1.getValueAt(1, 2), (Object)"V6");
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        DefaultTableModel m2 = new DefaultTableModel();
        Object[][] data2 = new Object[2][];
        Object[] row1 = new Object[]{"V1", "V2"};
        Object[] row2 = new Object[]{"V3", "V4", "V5", "V6"};
        data2[0] = row1;
        data2[1] = row2;
        Object[] columns2 = new Object[]{"C1", "C2", "C3"};
        m2.setDataVector(data2, columns2);
        harness.check(m2.getValueAt(0, 0), (Object)"V1");
        harness.check(m2.getValueAt(0, 1), (Object)"V2");
        harness.check(m2.getValueAt(0, 2), null);
        harness.check(m2.getValueAt(1, 0), (Object)"V3");
        harness.check(m2.getValueAt(1, 1), (Object)"V4");
        harness.check(m2.getValueAt(1, 2), (Object)"V5");
        harness.check(m2.getColumnName(0), (Object)"C1");
        harness.check(m2.getColumnName(1), (Object)"C2");
        harness.check(m2.getColumnName(2), (Object)"C3");
        harness.check(m2.getColumnCount(), 3);
        harness.check(m2.getRowCount(), 2);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("setDataVector(Vector, Vector)");
        DefaultTableModel m1 = new DefaultTableModel();
        Vector<String> v1 = new Vector<String>();
        v1.add("V1");
        v1.add("V2");
        v1.add("V3");
        Vector<String> v2 = new Vector<String>();
        v2.add("V4");
        v2.add("V5");
        v2.add("V6");
        Vector<Vector<String>> v = new Vector<Vector<String>>();
        v.add(v1);
        v.add(v2);
        Vector<String> columns = new Vector<String>();
        columns.add("C1");
        columns.add("C2");
        columns.add("C3");
        m1.setDataVector(v, columns);
        harness.check(m1.getValueAt(0, 0), (Object)"V1");
        harness.check(m1.getValueAt(0, 1), (Object)"V2");
        harness.check(m1.getValueAt(0, 2), (Object)"V3");
        harness.check(m1.getValueAt(1, 0), (Object)"V4");
        harness.check(m1.getValueAt(1, 1), (Object)"V5");
        harness.check(m1.getValueAt(1, 2), (Object)"V6");
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        DefaultTableModel m2 = new DefaultTableModel();
        Vector<String> vv1 = new Vector<String>();
        vv1.add("V1");
        vv1.add("V2");
        Vector<String> vv2 = new Vector<String>();
        vv2.add("V3");
        vv2.add("V4");
        vv2.add("V5");
        vv2.add("V6");
        Vector<Vector<String>> vv = new Vector<Vector<String>>();
        vv.add(vv1);
        vv.add(vv2);
        Vector<String> columns2 = new Vector<String>();
        columns2.add("C1");
        columns2.add("C2");
        columns2.add("C3");
        m2.setDataVector(vv, columns2);
        harness.check(m2.getValueAt(0, 0), (Object)"V1");
        harness.check(m2.getValueAt(0, 1), (Object)"V2");
        harness.check(m2.getValueAt(0, 2), null);
        harness.check(m2.getValueAt(1, 0), (Object)"V3");
        harness.check(m2.getValueAt(1, 1), (Object)"V4");
        harness.check(m2.getValueAt(1, 2), (Object)"V5");
        harness.check(m2.getColumnName(0), (Object)"C1");
        harness.check(m2.getColumnName(1), (Object)"C2");
        harness.check(m2.getColumnName(2), (Object)"C3");
        Vector<Vector> data = m2.getDataVector();
        Vector r1 = data.get(0);
        harness.check(r1.size(), 3);
        Vector r2 = data.get(1);
        harness.check(r2.size(), 3);
        DefaultTableModel m3 = new DefaultTableModel();
        m3.setDataVector((Vector<? extends Vector>)null, columns2);
        harness.check(m3.getColumnCount(), 3);
        harness.check(m3.getDataVector().size(), 0);
        DefaultTableModel m4 = new DefaultTableModel(2, 3);
        m4.setDataVector(vv, null);
        harness.check(m4.getColumnCount(), 0);
    }

    public void testEvent(TestHarness harness) {
        harness.checkPoint("Check TableModelEvent");
        DefaultTableModel m = new DefaultTableModel();
        MyTableModelListener listener = new MyTableModelListener();
        m.addTableModelListener(listener);
        Vector<String> v1 = new Vector<String>();
        v1.add("V1");
        v1.add("V2");
        v1.add("V3");
        Vector<String> v2 = new Vector<String>();
        v2.add("V4");
        v2.add("V5");
        v2.add("V6");
        Vector<Vector<String>> v = new Vector<Vector<String>>();
        v.add(v1);
        v.add(v2);
        Vector<String> columns = new Vector<String>();
        columns.add("C1");
        columns.add("C2");
        columns.add("C3");
        m.setDataVector(v, columns);
        TableModelEvent event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
    }
}

