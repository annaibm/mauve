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

public class removeElement
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
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        m.addListDataListener(this);
        m.removeElement("A");
        harness.check(m.getSize(), 2);
        harness.check(m.getElementAt(0), (Object)"B");
        harness.check(m.getSelectedItem(), (Object)"B");
        harness.check(this.events.size(), 2);
        ListDataEvent e0 = (ListDataEvent)this.events.get(0);
        harness.check(e0.getType(), 0);
        harness.check(e0.getIndex0(), -1);
        harness.check(e0.getIndex1(), -1);
        ListDataEvent e1 = (ListDataEvent)this.events.get(1);
        harness.check(e1.getType(), 2);
        harness.check(e1.getIndex0(), 0);
        harness.check(e1.getIndex1(), 0);
        this.events.clear();
        m.removeElement("C");
        harness.check(m.getSize(), 1);
        harness.check(m.getElementAt(0), (Object)"B");
        harness.check(m.getSelectedItem(), (Object)"B");
        harness.check(this.events.size(), 1);
        e0 = (ListDataEvent)this.events.get(0);
        harness.check(e0.getType(), 2);
        harness.check(e0.getIndex0(), 1);
        harness.check(e0.getIndex1(), 1);
        this.events.clear();
        m.removeElement("Z");
        harness.check(m.getSize(), 1);
        harness.check(m.getSelectedItem(), (Object)"B");
        harness.check(this.events.size(), 0);
    }
}

