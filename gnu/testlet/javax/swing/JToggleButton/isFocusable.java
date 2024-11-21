/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToggleButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JToggleButton;

public class isFocusable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JToggleButton i = new JToggleButton();
        harness.check(i.isFocusable(), true);
    }
}

