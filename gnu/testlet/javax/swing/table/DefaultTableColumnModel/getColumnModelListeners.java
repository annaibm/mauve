/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;

public class getColumnModelListeners
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        TableColumnModelListener[] listeners = m1.getColumnModelListeners();
        harness.check(listeners.length, 0);
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        listeners = m1.getColumnModelListeners();
        harness.check(listeners[0], listener);
        MyListener listener2 = new MyListener();
        m1.addColumnModelListener(listener2);
        listeners = m1.getColumnModelListeners();
        List<TableColumnModelListener> list2 = Arrays.asList(listeners);
        harness.check(list2.contains(listener));
        harness.check(list2.contains(listener2));
    }
}

