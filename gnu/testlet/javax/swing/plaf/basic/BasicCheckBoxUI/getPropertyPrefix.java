/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicCheckBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicCheckBoxUI.MyBasicCheckBoxUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicCheckBoxUI ui = new MyBasicCheckBoxUI();
        harness.check(ui.getPropertyPrefix(), (Object)"CheckBox.");
    }
}

