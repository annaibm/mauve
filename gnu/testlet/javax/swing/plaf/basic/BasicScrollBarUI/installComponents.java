/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI.MyBasicScrollBarUI;
import javax.swing.JScrollBar;

public class installComponents
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testIncrButton(harness);
        this.testDecrButton(harness);
    }

    private void testIncrButton(TestHarness harness) {
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        ui.setScrollbar(new JScrollBar());
        harness.check(ui.getIncrButton(), null);
        ui.installComponents();
        harness.check(ui.getIncrButton() != null);
    }

    private void testDecrButton(TestHarness harness) {
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        ui.setScrollbar(new JScrollBar());
        harness.check(ui.getDecrButton(), null);
        ui.installComponents();
        harness.check(ui.getDecrButton() != null);
    }
}

