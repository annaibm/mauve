/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.swing.JTable;

public class getAccessibleContext
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTable t = new JTable();
        AccessibleContext ac = t.getAccessibleContext();
        harness.check(ac.getAccessibleName(), null);
        harness.check(ac.getAccessibleRole(), AccessibleRole.TABLE);
        harness.check(ac.getAccessibleAction(), null);
        harness.check(ac.getAccessibleComponent(), ac);
        harness.check(ac.getAccessibleDescription(), null);
        harness.check(ac.getAccessibleEditableText(), null);
        harness.check(ac.getAccessibleIcon(), null);
        harness.check(ac.getAccessibleTable(), ac);
        harness.check(ac.getAccessibleText(), null);
    }
}

