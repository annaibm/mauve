/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;

public class getSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel();
        harness.check(m.getSize(), 0);
        m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        harness.check(m.getSize(), 3);
    }
}

