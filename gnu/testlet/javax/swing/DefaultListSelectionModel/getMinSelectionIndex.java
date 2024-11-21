/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class getMinSelectionIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getMinSelectionIndex(), -1);
        m.addSelectionInterval(99, 101);
        harness.check(m.getMinSelectionIndex(), 99);
        m.clearSelection();
        harness.check(m.getMinSelectionIndex(), -1);
    }
}

