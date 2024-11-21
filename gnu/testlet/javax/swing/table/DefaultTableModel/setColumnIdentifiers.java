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

public class setColumnIdentifiers
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBasics1(harness);
        this.testBasics2(harness);
        this.testEvents1(harness);
        this.testEvents2(harness);
    }

    public void testBasics1(TestHarness harness) {
        harness.checkPoint("setColumnIdentifiers(Object[])");
        DefaultTableModel m1 = new DefaultTableModel(1, 3);
        m1.setColumnIdentifiers(new Object[]{"C1", "C2", "C3"});
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        Vector<Vector> v1 = m1.getDataVector();
        Vector v1a = v1.get(0);
        harness.check(v1a.size(), 3);
        m1.setColumnIdentifiers(new Object[]{"SINGLE COLUMN"});
        harness.check(m1.getColumnCount(), 1);
        harness.check(m1.getColumnName(0), (Object)"SINGLE COLUMN");
        Vector<Vector> v2 = m1.getDataVector();
        Vector v2a = v2.get(0);
        harness.check(v2a.size(), 1);
        m1.setColumnIdentifiers((Object[])null);
        harness.check(m1.getColumnCount(), 0);
        Vector<Vector> v3 = m1.getDataVector();
        Vector v3a = v3.get(0);
        harness.check(v3a.size(), 0);
    }

    public void testBasics2(TestHarness harness) {
        harness.checkPoint("setColumnIdentifiers(Vector)");
        DefaultTableModel m1 = new DefaultTableModel(1, 3);
        Vector<String> v = new Vector<String>();
        v.add("C1");
        v.add("C2");
        v.add("C3");
        m1.setColumnIdentifiers(v);
        harness.check(m1.getColumnName(0), (Object)"C1");
        harness.check(m1.getColumnName(1), (Object)"C2");
        harness.check(m1.getColumnName(2), (Object)"C3");
        Vector<Vector> v1 = m1.getDataVector();
        Vector v1a = v1.get(0);
        harness.check(v1a.size(), 3);
        Vector<String> cols2 = new Vector<String>();
        cols2.add("SINGLE COLUMN");
        m1.setColumnIdentifiers(cols2);
        harness.check(m1.getColumnCount(), 1);
        harness.check(m1.getColumnName(0), (Object)"SINGLE COLUMN");
        Vector<Vector> v2 = m1.getDataVector();
        Vector v2a = v2.get(0);
        harness.check(v2a.size(), 1);
        m1.setColumnIdentifiers((Vector)null);
        harness.check(m1.getColumnCount(), 0);
        Vector<Vector> v3 = m1.getDataVector();
        Vector v3a = v3.get(0);
        harness.check(v3a.size(), 0);
    }

    public void testEvents1(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(1, 3);
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.setColumnIdentifiers(new Object[]{"C1", "C2", "C3"});
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
    }

    public void testEvents2(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(1, 3);
        Vector<String> v = new Vector<String>();
        v.add("C1");
        v.add("C2");
        v.add("C3");
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.setColumnIdentifiers(v);
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), -1);
        harness.check(event.getLastRow(), -1);
    }
}

