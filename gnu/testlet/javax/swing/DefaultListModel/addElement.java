/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class addElement
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("addElement(Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        harness.check(m1.getElementAt(0).equals("A"));
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        m1.addElement("B");
        harness.check(m1.getElementAt(1).equals("B"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        m1.addElement("C");
        harness.check(m1.getElementAt(2).equals("C"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 2);
        listener.setListDataEvent(null);
        m1.addElement(null);
        harness.check(m1.getElementAt(3) == null);
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 3);
        harness.check(event.getIndex1(), 3);
        listener.setListDataEvent(null);
    }
}

