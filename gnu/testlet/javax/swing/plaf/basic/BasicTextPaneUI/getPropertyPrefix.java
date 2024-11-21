/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicTextPaneUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicTextPaneUI.MyBasicTextPaneUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicTextPaneUI ui = new MyBasicTextPaneUI();
        harness.check(ui.getPropertyPrefix(), (Object)"TextPane");
    }
}

