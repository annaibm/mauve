/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;

public class getElementAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        harness.check(m.getElementAt(0), (Object)"A");
        harness.check(m.getElementAt(1), (Object)"B");
        harness.check(m.getElementAt(2), (Object)"C");
        harness.check(m.getElementAt(-1), null);
        harness.check(m.getElementAt(3), null);
    }
}

