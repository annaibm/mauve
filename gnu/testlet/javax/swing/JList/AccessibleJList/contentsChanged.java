/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;
import javax.swing.event.ListDataEvent;

public class contentsChanged
implements Testlet,
PropertyChangeListener {
    Vector receivedEvents = new Vector();

    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList();
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        al.addPropertyChangeListener(this);
        ListDataEvent ev = new ListDataEvent(l, 1, 1, 2);
        this.receivedEvents.clear();
        al.contentsChanged(ev);
        harness.check(this.receivedEvents.size(), 1);
        PropertyChangeEvent ev1 = (PropertyChangeEvent)this.receivedEvents.get(0);
        harness.check(ev1.getPropertyName(), (Object)"AccessibleVisibleData");
        harness.check(ev1.getSource(), al);
        harness.check(ev1.getOldValue(), Boolean.FALSE);
        harness.check(ev1.getNewValue(), Boolean.TRUE);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.receivedEvents.add(e);
    }
}

