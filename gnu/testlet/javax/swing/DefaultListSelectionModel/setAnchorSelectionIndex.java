/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class setAnchorSelectionIndex
implements Testlet,
ListSelectionListener {
    ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addSelectionInterval(2, 4);
        harness.check(m.getAnchorSelectionIndex(), 2);
        harness.check(m.isLeadAnchorNotificationEnabled(), true);
        m.addListSelectionListener(this);
        m.setAnchorSelectionIndex(1);
        harness.check(m.getAnchorSelectionIndex(), 1);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 2);
        this.lastEvent = null;
        m.setAnchorSelectionIndex(1);
        harness.check(this.lastEvent, null);
        m.setAnchorSelectionIndex(-2);
        harness.check(m.getAnchorSelectionIndex(), -2);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), -2);
        harness.check(this.lastEvent.getLastIndex(), 1);
        m.setLeadAnchorNotificationEnabled(false);
        this.lastEvent = null;
        m.setAnchorSelectionIndex(2);
        harness.check(m.getAnchorSelectionIndex(), 2);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(this.lastEvent, null);
    }
}

