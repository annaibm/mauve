/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class removeElement
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("removeElement(Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement("D");
        m1.addElement("D");
        m1.addElement("C");
        m1.addElement("B");
        m1.addElement("A");
        boolean removed = m1.removeElement("A");
        harness.check(m1.lastElement(), (Object)"A");
        harness.check(m1.size(), 7);
        harness.check(removed);
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 2);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        removed = m1.removeElement(null);
        harness.check(m1.size(), 7);
        harness.check(!removed);
        harness.check(listener.getEvent(), null);
    }
}

