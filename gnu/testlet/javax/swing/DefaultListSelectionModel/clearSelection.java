/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class clearSelection
implements Testlet,
ListSelectionListener {
    ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        this.testSingleSelection(harness);
        this.testSingleIntervalSelection(harness);
        this.testMultipleIntervalSelection(harness);
    }

    private void testSingleSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.addListSelectionListener(this);
        m.clearSelection();
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_SELECTION (2)");
        m.setSelectionInterval(3, 3);
        this.lastEvent = null;
        m.clearSelection();
        harness.check(m.isSelectionEmpty());
        harness.check(m.getAnchorSelectionIndex(), 3);
        harness.check(m.getLeadSelectionIndex(), 3);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 3);
        harness.check(this.lastEvent.getLastIndex(), 3);
    }

    private void testSingleIntervalSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        m.addListSelectionListener(this);
        harness.check(m.isSelectionEmpty(), true);
        this.lastEvent = null;
        m.clearSelection();
        harness.check(m.isSelectionEmpty(), true);
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (2)");
        m.addSelectionInterval(10, 20);
        this.lastEvent = null;
        m.clearSelection();
        harness.check(m.isSelectionEmpty(), true);
        harness.check(m.isSelectedIndex(10), false);
        harness.check(m.getAnchorSelectionIndex(), 10);
        harness.check(m.getLeadSelectionIndex(), 20);
        harness.check(m.getMinSelectionIndex(), -1);
        harness.check(m.getMaxSelectionIndex(), -1);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 10);
        harness.check(this.lastEvent.getLastIndex(), 20);
    }

    private void testMultipleIntervalSelection(TestHarness harness) {
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(2);
        m.addListSelectionListener(this);
        harness.check(m.isSelectionEmpty(), true);
        this.lastEvent = null;
        m.clearSelection();
        harness.check(m.isSelectionEmpty(), true);
        harness.check(this.lastEvent, null);
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION (2)");
        m.addSelectionInterval(2, 3);
        m.addSelectionInterval(12, 13);
        this.lastEvent = null;
        m.clearSelection();
        harness.check(m.isSelectionEmpty(), true);
        harness.check(m.getAnchorSelectionIndex(), 12);
        harness.check(m.getLeadSelectionIndex(), 13);
        harness.check(m.getMinSelectionIndex(), -1);
        harness.check(m.getMaxSelectionIndex(), -1);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 2);
        harness.check(this.lastEvent.getLastIndex(), 13);
    }
}

