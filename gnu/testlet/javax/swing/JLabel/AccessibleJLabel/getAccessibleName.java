/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel.AccessibleJLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;

public class getAccessibleName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("ABC");
        AccessibleContext ac = label.getAccessibleContext();
        harness.check(ac.getAccessibleName(), (Object)"ABC");
        JLabel label2 = new JLabel("JLabel2");
        label2.setLabelFor(label);
        harness.check(ac.getAccessibleName(), (Object)"ABC");
        label.setText(null);
        harness.check(ac.getAccessibleName(), (Object)"JLabel2");
        ac.setAccessibleName("XYZ");
        harness.check(ac.getAccessibleName(), (Object)"XYZ");
        label.setText("ABC");
        harness.check(ac.getAccessibleName(), (Object)"XYZ");
    }
}

