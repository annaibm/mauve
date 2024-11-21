/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableColumnModel;

public class setColumnMargin
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        m1.setColumnMargin(123);
        harness.check(m1.getColumnMargin(), 123);
        ChangeEvent e = listener.getChangeEvent();
        harness.check(e != null);
        harness.check(e.getSource(), m1);
        m1.setColumnMargin(-99);
        harness.check(m1.getColumnMargin(), -99);
    }
}

