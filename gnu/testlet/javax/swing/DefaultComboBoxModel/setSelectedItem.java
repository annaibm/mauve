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

public class setSelectedItem
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
        harness.check(m.getSelectedItem(), (Object)"A");
        m.addListDataListener(this);
        m.setSelectedItem("C");
        harness.check(this.events.size(), 1);
        harness.check(m.getSelectedItem(), (Object)"C");
        ListDataEvent event = (ListDataEvent)this.events.get(0);
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), -1);
        harness.check(event.getIndex1(), -1);
        this.events.clear();
        m.setSelectedItem(null);
        harness.check(m.getSelectedItem(), null);
        harness.check(this.events.size(), 1);
        event = (ListDataEvent)this.events.get(0);
        harness.check(event.getType(), 0);
        harness.check(event.getIndex0(), -1);
        harness.check(event.getIndex1(), -1);
        this.events.clear();
        m.setSelectedItem("Z");
        harness.check(m.getSelectedItem(), null);
        harness.check(m.getSize(), 3);
        harness.check(m.getIndexOf("Z"), -1);
        harness.check(this.events.size(), 0);
        m.setSelectedItem("Z");
        harness.check(this.events.size(), 0);
        m.setSelectedItem(null);
        this.events.clear();
        m.setSelectedItem(null);
        harness.check(this.events.size(), 0);
    }
}

