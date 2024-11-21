/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("DefaultTableModel()");
        DefaultTableModel m1 = new DefaultTableModel();
        harness.check(m1.getRowCount(), 0);
        harness.check(m1.getColumnCount(), 0);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DefaultTableModel(int, int)");
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        harness.check(m1.getRowCount(), 2);
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getValueAt(0, 0), null);
        harness.check(m1.getValueAt(1, 2), null);
        DefaultTableModel m2 = new DefaultTableModel(0, 0);
        harness.check(m2.getRowCount(), 0);
        harness.check(m2.getColumnCount(), 0);
        boolean pass = false;
        try {
            DefaultTableModel defaultTableModel = new DefaultTableModel(-1, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DefaultTableModel e = new DefaultTableModel(1, -1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("DefaultTableModel(Object[][], Object[])");
        Object[][] data1 = new Object[2][3];
        Object[] columns1 = new Object[]{"C1", "C2", "C3"};
        DefaultTableModel m1 = new DefaultTableModel(data1, columns1);
        harness.check(m1.getRowCount(), 2);
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        Object[] columns2 = new Object[]{"C1"};
        DefaultTableModel m2 = new DefaultTableModel(data1, columns2);
        harness.check(m2.getColumnName(0), (Object)"C1");
        harness.check(m2.getColumnCount(), 1);
        Object[] columns3 = new Object[]{"C1", "C2", "C3", "C4"};
        DefaultTableModel m3 = new DefaultTableModel(data1, columns3);
        harness.check(m3.getColumnCount(), 4);
        harness.check(m3.getColumnName(0), (Object)"C1");
        harness.check(m3.getColumnName(1), (Object)"C2");
        harness.check(m3.getColumnName(2), (Object)"C3");
        harness.check(m3.getColumnName(3), (Object)"C4");
        Object[] columns4 = new Object[]{null, null, null};
        DefaultTableModel m4 = new DefaultTableModel(data1, columns4);
        harness.check(m4.getColumnCount(), 3);
        harness.check(m4.getColumnName(0), (Object)"A");
        harness.check(m4.getColumnName(1), (Object)"B");
        harness.check(m4.getColumnName(2), (Object)"C");
        DefaultTableModel m5 = new DefaultTableModel((Object[][])null, columns1);
        harness.check(m5.getDataVector().size(), 0);
        harness.check(m5.getColumnCount(), 3);
        DefaultTableModel m6 = new DefaultTableModel(data1, null);
        harness.check(m6.getColumnCount(), 0);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("DefaultTableModel(Object[], int)");
        Object[] columns1 = new Object[]{"C1", "C2", "C3"};
        DefaultTableModel m1 = new DefaultTableModel(columns1, 2);
        harness.check(m1.getRowCount(), 2);
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        Object[] columns2 = new Object[]{};
        DefaultTableModel m2 = new DefaultTableModel(columns2, 2);
        harness.check(m2.getRowCount(), 2);
        harness.check(m2.getColumnCount(), 0);
        Object[] columns3 = new Object[]{"C1", null, "C3"};
        DefaultTableModel m3 = new DefaultTableModel(columns3, 2);
        harness.check(m3.getRowCount(), 2);
        harness.check(m3.getColumnCount(), 3);
        harness.check(m3.getColumnName(0), (Object)"C1");
        harness.check(m3.getColumnName(1), (Object)"B");
        harness.check(m3.getColumnName(2), (Object)"C3");
        Object[] columns4 = null;
        DefaultTableModel m4 = new DefaultTableModel(columns4, 2);
        harness.check(m4.getColumnCount(), 0);
        harness.check(m4.getRowCount(), 2);
        boolean pass = false;
        try {
            new DefaultTableModel(columns1, -1);
        }
        catch (RuntimeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("DefaultTableModel(Vector, int)");
        Vector<String> columns1 = new Vector<String>();
        columns1.add("C1");
        columns1.add("C2");
        columns1.add("C3");
        DefaultTableModel m1 = new DefaultTableModel(columns1, 2);
        harness.check(m1.getRowCount(), 2);
        harness.check(m1.getColumnCount(), 3);
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        Vector columns2 = new Vector();
        DefaultTableModel m2 = new DefaultTableModel(columns2, 2);
        harness.check(m2.getRowCount(), 2);
        harness.check(m2.getColumnCount(), 0);
        Vector<String> columns3 = new Vector<String>();
        columns3.add("C1");
        columns3.add(null);
        columns3.add("C3");
        DefaultTableModel m3 = new DefaultTableModel(columns3, 2);
        harness.check(m3.getRowCount(), 2);
        harness.check(m3.getColumnCount(), 3);
        harness.check(m3.getColumnName(0), (Object)"C1");
        harness.check(m3.getColumnName(1), (Object)"B");
        harness.check(m3.getColumnName(2), (Object)"C3");
        Vector<?> columns4 = null;
        boolean pass = false;
        try {
            DefaultTableModel defaultTableModel = new DefaultTableModel(columns4, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        pass = false;
        try {
            DefaultTableModel e = new DefaultTableModel(columns1, -1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

