/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class moveRow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[][] data = new Object[][]{{"A"}, {"B"}, {"C"}, {"D"}, {"E"}, {"F"}, {"G"}, {"H"}, {"I"}, {"J"}, {"K"}};
        DefaultTableModel m1 = new DefaultTableModel(data, new Object[]{"C1"});
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        m1.moveRow(1, 3, 5);
        harness.check(m1.getValueAt(0, 0), (Object)"A");
        harness.check(m1.getValueAt(1, 0), (Object)"E");
        harness.check(m1.getValueAt(2, 0), (Object)"F");
        harness.check(m1.getValueAt(3, 0), (Object)"G");
        harness.check(m1.getValueAt(4, 0), (Object)"H");
        harness.check(m1.getValueAt(5, 0), (Object)"B");
        harness.check(m1.getValueAt(6, 0), (Object)"C");
        harness.check(m1.getValueAt(7, 0), (Object)"D");
        harness.check(m1.getValueAt(8, 0), (Object)"I");
        harness.check(m1.getValueAt(9, 0), (Object)"J");
        harness.check(m1.getValueAt(10, 0), (Object)"K");
        TableModelEvent event = listener1.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 1);
        harness.check(event.getLastRow(), 7);
        listener1.setEvent(null);
        DefaultTableModel m2 = new DefaultTableModel(data, new Object[]{"C1"});
        m2.moveRow(6, 7, 1);
        harness.check(m2.getValueAt(0, 0), (Object)"A");
        harness.check(m2.getValueAt(1, 0), (Object)"G");
        harness.check(m2.getValueAt(2, 0), (Object)"H");
        harness.check(m2.getValueAt(3, 0), (Object)"B");
        harness.check(m2.getValueAt(4, 0), (Object)"C");
        harness.check(m2.getValueAt(5, 0), (Object)"D");
        harness.check(m2.getValueAt(6, 0), (Object)"E");
        harness.check(m2.getValueAt(7, 0), (Object)"F");
        harness.check(m2.getValueAt(8, 0), (Object)"I");
        harness.check(m2.getValueAt(9, 0), (Object)"J");
        harness.check(m2.getValueAt(10, 0), (Object)"K");
    }
}

