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
import javax.swing.event.ListSelectionEvent;

public class valueChanged
implements Testlet,
PropertyChangeListener {
    Vector receivedEvents = new Vector();

    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList();
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        al.addPropertyChangeListener(this);
        ListSelectionEvent ev = new ListSelectionEvent(l, 1, 2, true);
        this.receivedEvents.clear();
        al.valueChanged(ev);
        harness.check(this.receivedEvents.size(), 2);
        PropertyChangeEvent ev1 = (PropertyChangeEvent)this.receivedEvents.get(0);
        harness.check(ev1.getPropertyName(), (Object)"AccessibleVisibleData");
        harness.check(ev1.getSource(), al);
        harness.check(ev1.getOldValue(), Boolean.FALSE);
        harness.check(ev1.getNewValue(), Boolean.TRUE);
        PropertyChangeEvent ev2 = (PropertyChangeEvent)this.receivedEvents.get(1);
        harness.check(ev2.getPropertyName(), (Object)"AccessibleSelection");
        harness.check(ev2.getSource(), al);
        harness.check(ev2.getOldValue(), Boolean.FALSE);
        harness.check(ev2.getNewValue(), Boolean.TRUE);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.receivedEvents.add(e);
    }
}

