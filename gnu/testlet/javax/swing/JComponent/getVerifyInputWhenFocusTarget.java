/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JButton;

public class getVerifyInputWhenFocusTarget
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JButton c = new JButton("ABC");
        harness.check(c.getVerifyInputWhenFocusTarget(), true);
        c.setVerifyInputWhenFocusTarget(false);
        harness.check(c.getVerifyInputWhenFocusTarget(), false);
    }
}

