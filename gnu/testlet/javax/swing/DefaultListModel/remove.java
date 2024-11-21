/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("remove(int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement("D");
        m1.addElement("E");
        m1.addElement("F");
        Object removed = m1.remove(2);
        harness.check(m1.get(2), (Object)"D");
        harness.check(removed, (Object)"C");
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 2);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 2);
        listener.setListDataEvent(null);
        removed = m1.remove(0);
        harness.check(m1.get(0), (Object)"B");
        harness.check(removed, (Object)"A");
        event = listener.getEvent();
        harness.check(event.getType(), 2);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        boolean pass = false;
        try {
            m1.remove(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.remove(m1.size());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

