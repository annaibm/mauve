/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;

public class getIndexOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        harness.check(m.getIndexOf("A"), 0);
        harness.check(m.getIndexOf("B"), 1);
        harness.check(m.getIndexOf("C"), 2);
        harness.check(m.getIndexOf("D"), -1);
        harness.check(m.getIndexOf(null), -1);
        m.addElement(null);
        harness.check(m.getIndexOf(null), 3);
    }
}

