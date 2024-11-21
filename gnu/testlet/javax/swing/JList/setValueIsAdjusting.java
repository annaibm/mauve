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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class setValueIsAdjusting
implements Testlet,
PropertyChangeListener,
ListSelectionListener {
    List events = new ArrayList();

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.events.add(e);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JList list2 = new JList();
        list2.addListSelectionListener(this);
        harness.check(list2.getValueIsAdjusting(), false);
        harness.check(list2.getSelectionModel().getValueIsAdjusting(), false);
        list2.setValueIsAdjusting(true);
        harness.check(list2.getValueIsAdjusting(), true);
        harness.check(list2.getSelectionModel().getValueIsAdjusting(), true);
        harness.check(this.events.size(), 0);
        list2.getSelectionModel().setValueIsAdjusting(false);
        harness.check(list2.getValueIsAdjusting(), false);
    }
}

