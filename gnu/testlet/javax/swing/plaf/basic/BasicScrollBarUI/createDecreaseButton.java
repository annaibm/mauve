/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI.MyBasicScrollBarUI;
import javax.swing.JButton;

public class createDecreaseButton
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        harness.check(ui.getDecrButton(), null);
        JButton b1 = ui.createDecreaseButton(1);
        harness.check(ui.getDecrButton(), null);
        JButton b2 = ui.createDecreaseButton(1);
        harness.check(b1 != b2);
    }
}

