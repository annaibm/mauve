/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyTableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class newDataAvailable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[][] data = new Object[][]{{"A"}, {"B"}, {"C"}};
        DefaultTableModel m1 = new DefaultTableModel(data, new Object[]{"C1"});
        MyTableModelListener listener1 = new MyTableModelListener();
        m1.addTableModelListener(listener1);
        TableModelEvent event = new TableModelEvent(m1);
        m1.newDataAvailable(event);
        TableModelEvent received = listener1.getEvent();
        harness.check(received == event);
    }
}

