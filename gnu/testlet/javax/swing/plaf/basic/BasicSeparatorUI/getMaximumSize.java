/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSeparatorUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSeparator;
import javax.swing.plaf.basic.BasicSeparatorUI;

public class getMaximumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicSeparatorUI ui = new BasicSeparatorUI();
        JSeparator h = new JSeparator(0);
        harness.check(ui.getMaximumSize(h), null);
        JSeparator v = new JSeparator(1);
        harness.check(ui.getMaximumSize(v), null);
    }
}

