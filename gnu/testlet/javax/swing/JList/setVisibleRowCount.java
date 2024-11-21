/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;

public class setVisibleRowCount
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JList list2 = new JList();
        harness.check(list2.getVisibleRowCount(), 8);
        list2.addPropertyChangeListener(this);
        list2.setVisibleRowCount(13);
        harness.check(list2.getVisibleRowCount(), 13);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), list2);
        harness.check(e0.getPropertyName(), (Object)"visibleRowCount");
        harness.check(e0.getOldValue(), new Integer(8));
        harness.check(e0.getNewValue(), new Integer(13));
        this.events.clear();
        list2.setVisibleRowCount(13);
        harness.check(this.events.size(), 0);
        list2.setVisibleRowCount(0);
        harness.check(list2.getVisibleRowCount(), 0);
        this.events.clear();
        list2.setVisibleRowCount(-1);
        harness.check(list2.getVisibleRowCount(), 0);
        harness.check(this.events.size(), 1);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), list2);
        harness.check(e0.getPropertyName(), (Object)"visibleRowCount");
        harness.check(e0.getOldValue(), new Integer(0));
        harness.check(e0.getNewValue(), new Integer(-1));
        this.events.clear();
        list2.setVisibleRowCount(-99);
        harness.check(list2.getVisibleRowCount(), 0);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), list2);
        harness.check(e0.getPropertyName(), (Object)"visibleRowCount");
        harness.check(e0.getOldValue(), new Integer(0));
        harness.check(e0.getNewValue(), new Integer(-99));
    }
}

