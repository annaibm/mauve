/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class setSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("setSize(int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.setSize(5);
        harness.check(m1.size(), 5);
        harness.check(m1.getElementAt(3), null);
        harness.check(m1.getElementAt(4), null);
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 3);
        harness.check(event.getIndex1(), 4);
        listener.setListDataEvent(null);
        m1.setSize(2);
        harness.check(m1.size(), 2);
        harness.check(m1.getElementAt(0), (Object)"A");
        harness.check(m1.getElementAt(1), (Object)"B");
        event = listener.getEvent();
        harness.check(event.getType(), 2);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 4);
        listener.setListDataEvent(null);
    }
}

