/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicTextFieldUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicTextFieldUI.MyBasicTextFieldUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicTextFieldUI ui = new MyBasicTextFieldUI();
        harness.check(ui.getPropertyPrefix(), (Object)"TextField");
    }
}

