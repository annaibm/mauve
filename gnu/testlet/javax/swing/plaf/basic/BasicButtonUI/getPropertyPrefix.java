/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicButtonUI.MyBasicButtonUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicButtonUI ui = new MyBasicButtonUI();
        harness.check(ui.getPropertyPrefix(), (Object)"Button.");
    }
}

