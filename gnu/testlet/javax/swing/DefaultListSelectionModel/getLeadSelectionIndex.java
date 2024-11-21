/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class getLeadSelectionIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getLeadSelectionIndex(), -1);
        m.setAnchorSelectionIndex(1);
        m.setLeadSelectionIndex(3);
        harness.check(m.getLeadSelectionIndex(), 3);
        m.clearSelection();
        harness.check(m.getLeadSelectionIndex(), 3);
        m.addSelectionInterval(15, 11);
        harness.check(m.getLeadSelectionIndex(), 11);
    }
}

