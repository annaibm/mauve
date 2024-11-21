/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getSelectionMode(), 2);
        harness.check(m.isLeadAnchorNotificationEnabled(), true);
        harness.check(m.getAnchorSelectionIndex(), -1);
        harness.check(m.getLeadSelectionIndex(), -1);
        harness.check(m.getMaxSelectionIndex(), -1);
        harness.check(m.getMinSelectionIndex(), -1);
        harness.check(m.isSelectionEmpty(), true);
        harness.check(m.getValueIsAdjusting(), false);
    }
}

