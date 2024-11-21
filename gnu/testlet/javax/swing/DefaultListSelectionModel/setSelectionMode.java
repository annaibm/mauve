/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class setSelectionMode
implements Testlet,
ListSelectionListener {
    ListSelectionEvent lastEvent;

    @Override
    public void valueChanged(ListSelectionEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testIntervalToSingle(harness);
    }

    private void testGeneral(TestHarness harness) {
        harness.checkPoint("testGeneral()");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addListSelectionListener(this);
        harness.check(m.getSelectionMode(), 2);
        m.setSelectionMode(1);
        harness.check(m.getSelectionMode(), 1);
        harness.check(this.lastEvent, null);
        boolean pass = false;
        try {
            m.setSelectionMode(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testIntervalToSingle(TestHarness harness) {
        harness.checkPoint("testIntervalToSingle()");
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(1);
        m.addSelectionInterval(2, 4);
        m.addListSelectionListener(this);
        m.setSelectionMode(0);
        harness.check(m.getSelectionMode(), 0);
        harness.check(m.isSelectedIndex(2), true);
        harness.check(m.isSelectedIndex(3), true);
        harness.check(m.isSelectedIndex(4), true);
        harness.check(this.lastEvent, null);
    }
}

