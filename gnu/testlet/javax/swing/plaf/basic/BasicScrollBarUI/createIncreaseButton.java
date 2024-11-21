/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI.MyBasicScrollBarUI;
import javax.swing.JButton;

public class createIncreaseButton
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        harness.check(ui.getIncrButton(), null);
        JButton b1 = ui.createIncreaseButton(1);
        harness.check(ui.getIncrButton(), null);
        ui.setIncrButton(b1);
        JButton b2 = ui.createIncreaseButton(1);
        harness.check(b1 != b2);
    }
}

