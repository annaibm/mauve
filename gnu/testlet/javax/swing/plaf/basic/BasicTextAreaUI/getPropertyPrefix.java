/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicTextAreaUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicTextAreaUI.MyBasicTextAreaUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicTextAreaUI ui = new MyBasicTextAreaUI();
        harness.check(ui.getPropertyPrefix(), (Object)"TextArea");
    }
}

