/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicToggleButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicToggleButtonUI.MyBasicToggleButtonUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicToggleButtonUI ui = new MyBasicToggleButtonUI();
        harness.check(ui.getPropertyPrefix(), (Object)"ToggleButton.");
    }
}

