/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class getValueIsAdjusting
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.getValueIsAdjusting(), false);
        m.setValueIsAdjusting(true);
        harness.check(m.getValueIsAdjusting(), true);
    }
}

