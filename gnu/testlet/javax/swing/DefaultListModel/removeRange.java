/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultListModel.MyListDataListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

public class removeRange
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("removeRange(int, int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        MyListDataListener listener = new MyListDataListener();
        m1.addListDataListener(listener);
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement("D");
        m1.addElement("E");
        m1.addElement("F");
        m1.removeRange(0, 1);
        harness.check(m1.size(), 4);
        ListDataEvent event = listener.getEvent();
        harness.check(event.getType(), 2);
        harness.check(event.getIndex0(), 0);
        harness.check(event.getIndex1(), 1);
        listener.setListDataEvent(null);
        boolean pass = false;
        try {
            m1.removeRange(1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.removeRange(-1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

