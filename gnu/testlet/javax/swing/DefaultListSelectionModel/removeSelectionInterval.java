/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class removeSelectionInterval
implements Testlet,
ListSelectionListener {
    private ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        this.testSingleSelection(harness);
        this.testSingleInterval(harness);
        this.testMultipleInterval(harness);
    }

    public void testSingleSelection(TestHarness harness) {
        harness.checkPoint("SINGLE_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(0);
        m.addSelectionInterval(1, 2);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), false);
        m.addListSelectionListener(this);
        m.removeSelectionInterval(2, 3);
        harness.check(m.isSelectionEmpty(), true);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 2);
        harness.check(this.lastEvent.getLastIndex(), 3);
    }

    public void testSingleInterval(TestHarness harness) {
        harness.checkPoint("SINGLE_INTERVAL_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        m.addSelectionInterval(2, 6);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), false);
        m.addListSelectionListener(this);
        m.removeSelectionInterval(3, 5);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), false);
        harness.check(m.isSelectedIndex(6), false);
        harness.check(m.isSelectedIndex(7), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 2);
        harness.check(this.lastEvent.getLastIndex(), 6);
    }

    public void testMultipleInterval(TestHarness harness) {
        harness.checkPoint("MULTIPLE_INTERVAL_SELECTION");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(2);
        m.addSelectionInterval(2, 6);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(m.isSelectedIndex(5), true);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), false);
        m.addListSelectionListener(this);
        m.removeSelectionInterval(3, 5);
        harness.check(m.isSelectedIndex(1), false);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), false);
        harness.check(m.isSelectedIndex(4), false);
        harness.check(m.isSelectedIndex(5), false);
        harness.check(m.isSelectedIndex(6), true);
        harness.check(m.isSelectedIndex(7), false);
        harness.check(this.lastEvent.getSource(), m);
        harness.check(this.lastEvent.getFirstIndex(), 2);
        harness.check(this.lastEvent.getLastIndex(), 6);
    }
}

