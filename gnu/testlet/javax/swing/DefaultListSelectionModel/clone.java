/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class clone
implements Testlet,
ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m1 = new DefaultListSelectionModel();
        m1.setSelectionMode(1);
        m1.setLeadAnchorNotificationEnabled(false);
        m1.addListSelectionListener(this);
        m1.addSelectionInterval(5, 9);
        DefaultListSelectionModel m2 = null;
        try {
            m2 = (DefaultListSelectionModel)m1.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            // empty catch block
        }
        harness.check(m2.getSelectionMode(), 1);
        harness.check(m2.isLeadAnchorNotificationEnabled(), false);
        harness.check(m2.isSelectedIndex(4), false);
        harness.check(m2.isSelectedIndex(5), true);
        harness.check(m2.isSelectedIndex(9), true);
        harness.check(m2.isSelectedIndex(10), false);
        m2.clearSelection();
        harness.check(m2.isSelectionEmpty(), true);
        harness.check(m1.isSelectionEmpty(), false);
        ListSelectionListener[] listeners = m2.getListSelectionListeners();
        harness.check(listeners.length, 0);
        listeners = m1.getListSelectionListeners();
        harness.check(listeners.length, 1);
    }
}

