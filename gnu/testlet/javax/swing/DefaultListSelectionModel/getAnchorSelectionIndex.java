/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class getAnchorSelectionIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getAnchorSelectionIndex(), -1);
        m.setAnchorSelectionIndex(99);
        harness.check(m.getAnchorSelectionIndex(), 99);
        m.clearSelection();
        harness.check(m.getAnchorSelectionIndex(), 99);
        m.addSelectionInterval(15, 11);
        harness.check(m.getAnchorSelectionIndex(), 15);
    }
}

