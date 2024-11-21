/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;

public class addColumnModelListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        TableColumnModelListener[] listeners = m1.getColumnModelListeners();
        harness.check(listeners[0], listener);
        m1.addColumnModelListener(null);
        listeners = m1.getColumnModelListeners();
        harness.check(listeners.length, 1);
    }
}

