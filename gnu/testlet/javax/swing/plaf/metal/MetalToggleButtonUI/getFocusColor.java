/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalToggleButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalToggleButtonUI.MyMetalToggleButtonUI;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getFocusColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyMetalToggleButtonUI ui = new MyMetalToggleButtonUI();
        harness.check(ui.getFocusColor(), null);
        ui.installDefaults(new JToggleButton("Test"));
        harness.check(ui.getFocusColor(), MetalLookAndFeel.getFocusColor());
    }
}

