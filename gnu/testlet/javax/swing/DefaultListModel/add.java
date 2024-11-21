/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("add(int, Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        boolean pass = false;
        try {
            m1.add(-1, "X");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.add(1, "X");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(listener.getEvent(), null);
        m1.add(0, "A");
        harness.check(m1.getElementAt(0).equals("A"));
        ListDataEvent event = listener.getEvent();
        System.out.println(event);
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        m1.add(1, "B");
        harness.check(m1.getElementAt(1).equals("B"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 1);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        m1.add(2, "C");
        harness.check(m1.getElementAt(2).equals("C"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 2);
        harness.check(event.getIndex1(), 2);
        listener.setListDataEvent(null);
        m1.add(0, "Z");
        harness.check(m1.getElementAt(0).equals("Z"));
        harness.check(m1.getElementAt(3).equals("C"));
        event = listener.getEvent();
        harness.check(event.getType(), 1);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 0);
        listener.setListDataEvent(null);
        m1.add(1, "Y");
        harness.check(m1.getElementAt(0).equals("Z"));
        harness.check(m1.getElementAt(1).equals("Y"));
        harness.check(m1.getElementAt(4).equals("C"));
        m1.add(2, null);
        harness.check(m1.getElementAt(0).equals("Z"));
        harness.check(m1.getElementAt(1).equals("Y"));
        harness.check(m1.getElementAt(2) == null);
        harness.check(m1.getElementAt(5).equals("C"));
    }
}

