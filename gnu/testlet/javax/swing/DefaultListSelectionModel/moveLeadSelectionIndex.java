/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class moveLeadSelectionIndex
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
        m.addSelectionInterval(3, 5);
        m.addListSelectionListener(this);
        m.moveLeadSelectionIndex(7);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.isSelectedIndex(7), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 5);
        harness.check(this.lastEvent.getLastIndex(), 7);
    }
}

