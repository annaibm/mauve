/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicButtonUI.MyBasicButtonUI;
import javax.swing.JButton;

public class defaultTextShiftOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicButtonUI ui = new MyBasicButtonUI();
        harness.check(ui.getDefaultTextShiftOffsetField(), 0);
        ui.installUI(new JButton());
        harness.check(ui.getDefaultTextShiftOffsetField(), 0);
    }
}

