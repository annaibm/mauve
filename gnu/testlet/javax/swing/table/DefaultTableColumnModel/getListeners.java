/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import java.util.EventListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;

public class getListeners
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        EventListener[] listeners = m1.getListeners(TableColumnModelListener.class);
        harness.check(listeners.length, 0);
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        listeners = m1.getListeners(TableColumnModelListener.class);
        harness.check(listeners[0], listener);
        boolean pass = false;
        try {
            listeners = m1.getListeners(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

