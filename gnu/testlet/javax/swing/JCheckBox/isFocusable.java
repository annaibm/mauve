/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JCheckBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JCheckBox;

public class isFocusable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JCheckBox i = new JCheckBox();
        harness.check(i.isFocusable(), true);
    }
}

