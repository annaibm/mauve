/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRadioButtonMenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JRadioButtonMenuItem;

public class isFocusable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JRadioButtonMenuItem i = new JRadioButtonMenuItem();
        harness.check(i.isFocusable(), false);
    }
}

