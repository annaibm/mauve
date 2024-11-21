/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class setValueIsAdjusting
implements Testlet,
ListSelectionListener {
    ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addListSelectionListener(this);
        harness.check(m.getValueIsAdjusting(), false);
        m.setValueIsAdjusting(true);
        harness.check(this.lastEvent, null);
        m.addSelectionInterval(3, 5);
        harness.check(this.lastEvent.getValueIsAdjusting(), true);
        m.setValueIsAdjusting(false);
        m.addSelectionInterval(1, 2);
        harness.check(this.lastEvent.getValueIsAdjusting(), false);
    }
}

