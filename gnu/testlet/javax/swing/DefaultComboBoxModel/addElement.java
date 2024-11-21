/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class addElement
implements Testlet,
ListDataListener {
    List events = new ArrayList();

    @Override
    public void contentsChanged(ListDataEvent event) {
        this.events.add(event);
    }

    @Override
    public void intervalAdded(ListDataEvent event) {
        this.events.add(event);
    }

    @Override
    public void intervalRemoved(ListDataEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        DefaultComboBoxModel<String> m = new DefaultComboBoxModel<String>();
        m.addListDataListener(this);
        m.addElement("A");
        harness.check(m.getSize(), 1);
        harness.check(m.getElementAt(0), (Object)"A");
        harness.check(m.getSelectedItem(), (Object)"A");
        harness.check(this.events.size(), 2);
        ListDataEvent e = (ListDataEvent)this.events.get(0);
        harness.check(e.getType(), 1);
        harness.check(e.getIndex0(), 0);
        harness.check(e.getIndex1(), 0);
        e = (ListDataEvent)this.events.get(1);
        harness.check(e.getType(), 0);
        harness.check(e.getIndex0(), -1);
        harness.check(e.getIndex1(), -1);
        this.events.clear();
        m.addElement("B");
        harness.check(m.getSize(), 2);
        harness.check(m.getElementAt(1), (Object)"B");
        harness.check(m.getSelectedItem(), (Object)"A");
        harness.check(this.events.size(), 1);
        e = (ListDataEvent)this.events.get(0);
        harness.check(e.getType(), 1);
        harness.check(e.getIndex0(), 1);
        harness.check(e.getIndex1(), 1);
        this.events.clear();
        m.addElement(null);
        harness.check(m.getSize(), 3);
        harness.check(m.getElementAt(2), null);
        harness.check(m.getSelectedItem(), (Object)"A");
        harness.check(this.events.size(), 1);
        e = (ListDataEvent)this.events.get(0);
        harness.check(e.getType(), 1);
        harness.check(e.getIndex0(), 2);
        harness.check(e.getIndex1(), 2);
        this.events.clear();
    }
}

