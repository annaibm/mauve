/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.swing.JLabel;

public class getAccessibleContext
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("ABC");
        AccessibleContext ac = label.getAccessibleContext();
        harness.check(ac.getAccessibleRole(), AccessibleRole.LABEL);
        harness.check(ac.getAccessibleName(), (Object)"ABC");
        harness.check(ac.getAccessibleDescription(), null);
    }
}

