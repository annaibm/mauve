/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class set
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("set(int, Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        String old = m1.set(0, "X");
        harness.check(m1.get(0), (Object)"X");
        harness.check(old, (Object)"A");
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        old = m1.set(1, "Y");
        harness.check(m1.get(1), (Object)"Y");
        harness.check(old, (Object)"B");
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        old = m1.set(2, "Z");
        harness.check(m1.get(2), (Object)"Z");
        harness.check(old, (Object)"C");
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 2);
        listener.setListDataEvent(null);
        old = m1.set(1, null);
        harness.check(m1.get(1), null);
        harness.check(old, (Object)"Y");
        event = listener.getEvent();
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        boolean pass = false;
        try {
            m1.set(-1, "ZZ");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.set(3, "ZZ");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

