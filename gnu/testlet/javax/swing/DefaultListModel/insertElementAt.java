/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class insertElementAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("insertElementAt(int, Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        boolean pass = false;
        try {
            m1.insertElementAt("X", -1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.insertElementAt("X", 1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        m1.insertElementAt("A", 0);
        harness.check(m1.getElementAt(0).equals("A"));
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        m1.insertElementAt("B", 1);
        harness.check(m1.getElementAt(1).equals("B"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        m1.insertElementAt("C", 2);
        harness.check(m1.getElementAt(2).equals("C"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 2);
        listener.setListDataEvent(null);
        m1.insertElementAt("Z", 0);
        harness.check(m1.getElementAt(0).equals("Z"));
        harness.check(m1.getElementAt(3).equals("C"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        m1.insertElementAt("Y", 1);
        harness.check(m1.getElementAt(0).equals("Z"));
        harness.check(m1.getElementAt(1).equals("Y"));
        harness.check(m1.getElementAt(4).equals("C"));
        m1.insertElementAt(null, 2);
        harness.check(m1.getElementAt(0).equals("Z"));
        harness.check(m1.getElementAt(1).equals("Y"));
        harness.check(m1.getElementAt(2) == null);
        harness.check(m1.getElementAt(5).equals("C"));
    }
}

