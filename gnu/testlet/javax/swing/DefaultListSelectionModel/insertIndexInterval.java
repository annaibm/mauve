/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class insertIndexInterval
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
        this.testSingleInterval(harness);
        this.testMultipleInterval(harness);
    }

    private void testSingleSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.addSelectionInterval(3, 3);
        m.addListSelectionListener(this);
        m.insertIndexInterval(3, 2, true);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.getAnchorSelectionIndex(), 5);
        harness.check(m.getLeadSelectionIndex(), 5);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 3);
        harness.check(this.lastEvent.getLastIndex(), 5);
        harness.checkPoint("SINGLE_SELECTION (2)");
        this.lastEvent = null;
        m.insertIndexInterval(5, 2, false);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.isSelectedIndex(7), false);
        harness.check(this.lastEvent, null);
        harness.checkPoint("SINGLE_SELECTION (3)");
        boolean pass = false;
        try {
            m.insertIndexInterval(-1, 1, true);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("SINGLE_SELECTION (4)");
        pass = false;
        try {
            m.insertIndexInterval(0, -1, true);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("SINGLE_SELECTION (5)");
        this.lastEvent = null;
        m.insertIndexInterval(0, 0, true);
        harness.check(this.lastEvent.getFirstIndex(), 0);
        harness.check(this.lastEvent.getLastIndex(), 6);
    }

    private void testSingleInterval(TestHarness harness) {
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        m.setSelectionInterval(3, 3);
        m.addListSelectionListener(this);
        m.insertIndexInterval(3, 2, true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.getAnchorSelectionIndex(), 5);
        harness.check(m.getLeadSelectionIndex(), 5);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 3);
        harness.check(this.lastEvent.getLastIndex(), 5);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (2)");
        m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        m.setSelectionInterval(3, 3);
        m.addListSelectionListener(this);
        this.lastEvent = null;
        m.insertIndexInterval(3, 2, false);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.getAnchorSelectionIndex(), 3);
        harness.check(m.getLeadSelectionIndex(), 3);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 4);
        harness.check(this.lastEvent.getLastIndex(), 5);
        boolean pass = false;
        try {
            m.insertIndexInterval(-1, 1, true);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.insertIndexInterval(0, -1, true);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        this.lastEvent = null;
        m.insertIndexInterval(0, 0, true);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 0);
        harness.check(this.lastEvent.getLastIndex(), 6);
    }

    private void testMultipleInterval(TestHarness harness) {
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(2);
        m.addSelectionInterval(1, 1);
        m.addSelectionInterval(7, 7);
        m.addSelectionInterval(3, 5);
        m.addListSelectionListener(this);
        m.insertIndexInterval(2, 2, true);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), true);
        harness.check(m.isSelectedIndex(8), false);
        harness.check(m.isSelectedIndex(9), true);
        harness.check(m.isSelectedIndex(10), false);
        harness.check(m.getAnchorSelectionIndex(), 5);
        harness.check(m.getLeadSelectionIndex(), 7);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 3);
        harness.check(this.lastEvent.getLastIndex(), 9);
        m.insertIndexInterval(1, 2, false);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), false);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.isSelectedIndex(7), true);
        harness.check(m.isSelectedIndex(8), true);
        harness.check(m.isSelectedIndex(9), true);
        harness.check(m.isSelectedIndex(10), false);
        harness.check(m.isSelectedIndex(11), true);
        harness.check(m.isSelectedIndex(12), false);
        harness.check(m.getAnchorSelectionIndex(), 7);
        harness.check(m.getLeadSelectionIndex(), 9);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 2);
        harness.check(this.lastEvent.getLastIndex(), 11);
    }
}

