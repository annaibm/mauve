/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class isSelectedIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.isSelectedIndex(99), false);
        m.addSelectionInterval(99, 99);
        harness.check(m.isSelectedIndex(99), true);
        m.clearSelection();
        harness.check(m.isSelectedIndex(99), false);
        harness.check(m.isSelectedIndex(-1), false);
        harness.check(m.isSelectedIndex(-2), false);
    }
}

