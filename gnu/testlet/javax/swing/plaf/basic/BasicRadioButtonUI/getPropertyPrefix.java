/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicRadioButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicRadioButtonUI.MyBasicRadioButtonUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicRadioButtonUI ui = new MyBasicRadioButtonUI();
        harness.check(ui.getPropertyPrefix(), (Object)"RadioButton.");
    }
}

