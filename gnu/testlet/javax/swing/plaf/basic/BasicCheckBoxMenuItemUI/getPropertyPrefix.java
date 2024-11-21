/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicCheckBoxMenuItemUI.MyBasicCheckBoxMenuItemUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicCheckBoxMenuItemUI ui = new MyBasicCheckBoxMenuItemUI();
        harness.check(ui.getPropertyPrefix(), (Object)"CheckBoxMenuItem");
    }
}

