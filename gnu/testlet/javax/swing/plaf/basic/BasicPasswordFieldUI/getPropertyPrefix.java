/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicPasswordFieldUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicPasswordFieldUI.MyBasicPasswordFieldUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicPasswordFieldUI ui = new MyBasicPasswordFieldUI();
        harness.check(ui.getPropertyPrefix(), (Object)"PasswordField");
    }
}

