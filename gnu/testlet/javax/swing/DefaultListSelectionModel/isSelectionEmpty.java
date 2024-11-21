/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class isSelectionEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.isSelectionEmpty(), true);
        m.addSelectionInterval(99, 99);
        harness.check(m.isSelectionEmpty(), false);
        m.clearSelection();
        harness.check(m.isSelectionEmpty(), true);
    }
}

