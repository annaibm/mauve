/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicMenuItemUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicMenuItemUI.MyBasicMenuItemUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicMenuItemUI ui = new MyBasicMenuItemUI();
        harness.check(ui.getPropertyPrefix(), (Object)"MenuItem");
    }
}

