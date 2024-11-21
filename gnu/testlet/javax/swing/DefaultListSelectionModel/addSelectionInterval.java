/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class addSelectionInterval
implements Testlet,
ListSelectionListener {
    ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        this.testSingleSelection(harness);
        this.testSingleIntervalSelection(harness);
        this.testMultipleIntervalSelection(harness);
    }

    private void testSingleSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addListSelectionListener(this);
        m.setSelectionMode(0);
        m.addSelectionInterval(1, 3);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.getAnchorSelectionIndex(), 3);
        harness.check(m.getLeadSelectionIndex(), 3);
        harness.check(m.getMaxSelectionIndex(), 3);
        harness.check(m.getMinSelectionIndex(), 3);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 3);
        harness.check(this.lastEvent.getLastIndex(), 3);
        m.clearSelection();
        m.addSelectionInterval(3, 1);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.getAnchorSelectionIndex(), 1);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(m.getMaxSelectionIndex(), 1);
        harness.check(m.getMinSelectionIndex(), 1);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 3);
    }

    private void testSingleIntervalSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_INTERVAL_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addListSelectionListener(this);
        m.setSelectionMode(1);
        m.addSelectionInterval(1, 3);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.getAnchorSelectionIndex(), 1);
        harness.check(m.getLeadSelectionIndex(), 3);
        harness.check(m.getMaxSelectionIndex(), 3);
        harness.check(m.getMinSelectionIndex(), 1);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 3);
        m.addSelectionInterval(5, 6);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), false);
        harness.check(m.getAnchorSelectionIndex(), 5);
        harness.check(m.getLeadSelectionIndex(), 6);
        harness.check(m.getMaxSelectionIndex(), 6);
        harness.check(m.getMinSelectionIndex(), 5);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 6);
        m.addSelectionInterval(7, 8);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), true);
        harness.check(m.isSelectedIndex(8), true);
        harness.check(m.isSelectedIndex(9), false);
        harness.check(m.getAnchorSelectionIndex(), 7);
        harness.check(m.getLeadSelectionIndex(), 8);
        harness.check(m.getMaxSelectionIndex(), 8);
        harness.check(m.getMinSelectionIndex(), 5);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 5);
        harness.check(this.lastEvent.getLastIndex(), 8);
        m.addSelectionInterval(3, 4);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), true);
        harness.check(m.isSelectedIndex(8), true);
        harness.check(m.isSelectedIndex(9), false);
        harness.check(m.getAnchorSelectionIndex(), 3);
        harness.check(m.getLeadSelectionIndex(), 4);
        harness.check(m.getMaxSelectionIndex(), 8);
        harness.check(m.getMinSelectionIndex(), 3);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 3);
        harness.check(this.lastEvent.getLastIndex(), 8);
        m.clearSelection();
        m.addSelectionInterval(3, 1);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.getAnchorSelectionIndex(), 3);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(m.getMaxSelectionIndex(), 3);
        harness.check(m.getMinSelectionIndex(), 1);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 4);
    }

    private void testMultipleIntervalSelection(TestHarness harness) {
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addSelectionInterval(1, 3);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        m.clearSelection();
        m.addSelectionInterval(2, 1);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), false);
        m.clearSelection();
        m.addSelectionInterval(-1, 1);
        harness.check(m.isSelectedIndex(-2), false);
        harness.check(m.isSelectedIndex(-1), false);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), false);
    }
}

