/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class setSelectionInterval
implements Testlet,
ListSelectionListener {
    List events = new ArrayList();

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        this.testSingle(harness);
        this.testSingleInterval(harness);
        this.testMultipleInterval(harness);
        this.testSingleX(harness);
    }

    private void testSingle(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.addListSelectionListener(this);
        harness.checkPoint("SINGLE_SELECTION (1)");
        m.setSelectionInterval(6, 7);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.isSelectedIndex(7), true);
        harness.check(m.getAnchorSelectionIndex(), 7);
        harness.check(m.getLeadSelectionIndex(), 7);
        ListSelectionEvent lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 7);
        harness.check(lastEvent.getLastIndex(), 7);
        this.events.clear();
        harness.checkPoint("SINGLE_SELECTION (2)");
        m.setSelectionInterval(6, 7);
        harness.check(this.events.size(), 0);
        this.events.clear();
        harness.checkPoint("SINGLE_SELECTION (3)");
        m.setSelectionInterval(3, 3);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(7), false);
        lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 3);
        harness.check(lastEvent.getLastIndex(), 7);
        harness.checkPoint("SINGLE_SELECTION (4)");
        m.setAnchorSelectionIndex(5);
        this.events.clear();
        m.setSelectionInterval(4, 4);
        lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 3);
        harness.check(lastEvent.getLastIndex(), 5);
        harness.checkPoint("SINGLE_SELECTION (5)");
        m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.setSelectionInterval(2, 2);
        m.addListSelectionListener(this);
        this.events.clear();
        m.setSelectionInterval(-2, 0);
        lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 0);
        harness.check(lastEvent.getLastIndex(), 2);
        harness.check(m.getLeadSelectionIndex(), 0);
        harness.check(m.getAnchorSelectionIndex(), 0);
        harness.checkPoint("SINGLE_SELECTION (6)");
        m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.setSelectionInterval(2, 2);
        m.addListSelectionListener(this);
        this.events.clear();
        m.setSelectionInterval(-1, 0);
        harness.check(this.events.size(), 0);
        harness.checkPoint("SINGLE_SELECTION (7)");
        m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.setSelectionInterval(2, 2);
        m.addListSelectionListener(this);
        this.events.clear();
        boolean pass = false;
        try {
            m.setSelectionInterval(0, -2);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("SINGLE_SELECTION (8)");
        m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.setSelectionInterval(2, 2);
        m.addListSelectionListener(this);
        this.events.clear();
        m.setSelectionInterval(0, -1);
        harness.check(this.events.size(), 0);
    }

    private void testSingleInterval(TestHarness harness) {
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (1)");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        this.events.clear();
        m.addListSelectionListener(this);
        m.setSelectionInterval(6, 7);
        harness.check(m.isSelectedIndex(5), false);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), true);
        harness.check(m.isSelectedIndex(8), false);
        harness.check(m.getAnchorSelectionIndex(), 6);
        harness.check(m.getLeadSelectionIndex(), 7);
        harness.check(this.events.size(), 1);
        ListSelectionEvent lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 6);
        harness.check(lastEvent.getLastIndex(), 7);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (2)");
        this.events.clear();
        m.setSelectionInterval(6, 7);
        harness.check(this.events.size(), 0);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (3)");
        this.events.clear();
        m.setSelectionInterval(3, 3);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.isSelectedIndex(7), false);
        harness.check(this.events.size(), 1);
        lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 3);
        harness.check(lastEvent.getLastIndex(), 7);
        harness.checkPoint("SINGLE_INTERVAL_SELECTION (3)");
        m.setAnchorSelectionIndex(5);
        this.events.clear();
        m.setSelectionInterval(4, 4);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), false);
        lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 3);
        harness.check(lastEvent.getLastIndex(), 5);
    }

    private void testMultipleInterval(TestHarness harness) {
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(2);
        this.events.clear();
        m.addListSelectionListener(this);
        m.setSelectionInterval(3, 5);
        harness.check(m.isSelectedIndex(2), false);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.getAnchorSelectionIndex(), 3);
        harness.check(m.getLeadSelectionIndex(), 5);
        harness.check(m.getMinSelectionIndex(), 3);
        harness.check(m.getMaxSelectionIndex(), 5);
        harness.check(this.events.size(), 1);
        ListSelectionEvent lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 3);
        harness.check(lastEvent.getLastIndex(), 5);
        this.events.clear();
        m.setSelectionInterval(2, 3);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), false);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.getAnchorSelectionIndex(), 2);
        harness.check(m.getLeadSelectionIndex(), 3);
        harness.check(m.getMinSelectionIndex(), 2);
        harness.check(m.getMaxSelectionIndex(), 3);
        lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 2);
        harness.check(lastEvent.getLastIndex(), 5);
    }

    private void testSingleX(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION_X");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addSelectionInterval(2, 4);
        m.setSelectionMode(0);
        this.events.clear();
        m.addListSelectionListener(this);
        m.setSelectionInterval(0, 1);
        harness.check(m.isSelectedIndex(0), false);
        harness.check(m.isSelectedIndex(1), true);
        harness.check(m.getAnchorSelectionIndex(), 1);
        harness.check(m.getLeadSelectionIndex(), 1);
        harness.check(this.events.size(), 1);
        ListSelectionEvent lastEvent = (ListSelectionEvent)this.events.get(0);
        harness.check(lastEvent.getSource(), m);
        harness.check(lastEvent.getFirstIndex(), 1);
        harness.check(lastEvent.getLastIndex(), 4);
    }
}

