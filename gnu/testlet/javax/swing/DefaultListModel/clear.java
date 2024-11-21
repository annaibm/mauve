/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class clear
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("clear()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.clear();
        harness.check(m1.isEmpty());
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 2);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        m1.clear();
        harness.check(m1.isEmpty());
        harness.check(listener.getEvent(), null);
    }
}

