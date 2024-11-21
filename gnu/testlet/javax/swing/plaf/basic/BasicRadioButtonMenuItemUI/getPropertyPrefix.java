/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicRadioButtonMenuItemUI.MyBasicRadioButtonMenuItemUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicRadioButtonMenuItemUI ui = new MyBasicRadioButtonMenuItemUI();
        harness.check(ui.getPropertyPrefix(), (Object)"RadioButtonMenuItem");
    }
}

