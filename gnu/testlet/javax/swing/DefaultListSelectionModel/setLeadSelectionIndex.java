/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class setLeadSelectionIndex
implements Testlet,
ListSelectionListener {
    ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        this.testSetMinusOne(harness);
        this.testSetPositive(harness);
        this.testSingleSelection(harness);
        this.testSingleIntervalSelection(harness);
        this.testMultipleIntervalSelection(harness);
    }

    private void testSetMinusOne(TestHarness harness) {
        harness.checkPoint("setMinusOne");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setAnchorSelectionIndex(1);
        m.setLeadSelectionIndex(1);
        harness.check(m.getLeadSelectionIndex(), 1);
        m.setLeadSelectionIndex(-1);
        harness.check(m.getLeadSelectionIndex(), 1);
        m.setAnchorSelectionIndex(-1);
        m.setLeadSelectionIndex(-1);
        harness.check(m.getLeadSelectionIndex(), -1);
    }

    private void testSetPositive(TestHarness harness) {
        harness.checkPoint("setPositive");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getLeadSelectionIndex(), -1);
        harness.check(m.getAnchorSelectionIndex(), -1);
        m.setLeadSelectionIndex(0);
        harness.check(m.getLeadSelectionIndex(), -1);
        m.setAnchorSelectionIndex(0);
        m.setLeadSelectionIndex(0);
        harness.check(m.getLeadSelectionIndex(), 0);
    }

    private void testSingleSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.setLeadAnchorNotificationEnabled(true);
        m.addListSelectionListener(this);
        m.setLeadSelectionIndex(2);
        harness.check(m.getLeadSelectionIndex(), -1);
        harness.check(m.getAnchorSelectionIndex(), -1);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_SELECTION (2)");
        m.setSelectionInterval(2, 2);
        this.lastEvent = null;
        m.setLeadSelectionIndex(1);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(m.getAnchorSelectionIndex(), 1);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 2);
        harness.checkPoint("SINGLE_SELECTION (3)");
        this.lastEvent = null;
        m.setLeadSelectionIndex(-1);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(m.getAnchorSelectionIndex(), 1);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_SELECTION (4)");
        boolean pass = false;
        try {
            m.setLeadSelectionIndex(-2);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testSingleIntervalSelection(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        m.addListSelectionListener(this);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (1)");
        m.setLeadSelectionIndex(2);
        harness.check(m.getLeadSelectionIndex(), -1);
        harness.check(m.getAnchorSelectionIndex(), -1);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (2)");
        m.setSelectionInterval(2, 4);
        this.lastEvent = null;
        m.setLeadSelectionIndex(1);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(m.getAnchorSelectionIndex(), 2);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 4);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (3)");
        this.lastEvent = null;
        m.setLeadSelectionIndex(-1);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(m.getAnchorSelectionIndex(), 2);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (4)");
        boolean pass = false;
        try {
            m.setLeadSelectionIndex(-2);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testMultipleIntervalSelection(TestHarness harness) {
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(2);
        m.addSelectionInterval(3, 6);
        m.addListSelectionListener(this);
        m.setLeadSelectionIndex(1);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), false);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 1);
        harness.check(this.lastEvent.getLastIndex(), 6);
    }
}

