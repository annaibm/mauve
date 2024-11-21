/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class isLeadAnchorNotificationEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.isLeadAnchorNotificationEnabled(), true);
        m.setLeadAnchorNotificationEnabled(false);
        harness.check(m.isLeadAnchorNotificationEnabled(), false);
    }
}

