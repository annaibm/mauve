/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicMenuUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicMenuUI.MyBasicMenuUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicMenuUI ui = new MyBasicMenuUI();
        harness.check(ui.getPropertyPrefix(), (Object)"Menu");
    }
}

