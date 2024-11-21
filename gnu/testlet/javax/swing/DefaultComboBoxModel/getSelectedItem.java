/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;

public class getSelectedItem
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        harness.check(m.getSelectedItem(), (Object)"A");
        m.setSelectedItem("C");
        harness.check(m.getSelectedItem(), (Object)"C");
        m.setSelectedItem(null);
        harness.check(m.getSelectedItem(), null);
    }
}

