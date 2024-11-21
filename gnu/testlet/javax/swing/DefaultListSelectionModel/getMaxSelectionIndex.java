/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class getMaxSelectionIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getMaxSelectionIndex(), -1);
        m.addSelectionInterval(99, 101);
        harness.check(m.getMaxSelectionIndex(), 101);
        m.clearSelection();
        harness.check(m.getMaxSelectionIndex(), -1);
    }
}

