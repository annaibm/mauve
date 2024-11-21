/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRadioButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JRadioButton;

public class isFocusable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JRadioButton i = new JRadioButton();
        harness.check(i.isFocusable(), true);
    }
}

