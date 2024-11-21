/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class setElementAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("setElementAt()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.setElementAt("X", 0);
        harness.check(m1.get(0), (Object)"X");
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        m1.setElementAt("Y", 1);
        harness.check(m1.get(1), (Object)"Y");
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        m1.setElementAt("Z", 2);
        harness.check(m1.get(2), (Object)"Z");
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 2);
        listener.setListDataEvent(null);
        m1.setElementAt("Y", 1);
        harness.check(m1.get(1), (Object)"Y");
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        m1.setElementAt(null, 1);
        harness.check(m1.get(1), null);
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        boolean pass = false;
        try {
            m1.setElementAt("ZZ", -1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.setElementAt("ZZ", 99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

