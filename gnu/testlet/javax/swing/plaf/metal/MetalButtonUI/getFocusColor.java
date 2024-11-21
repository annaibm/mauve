/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalButtonUI.MyMetalButtonUI;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getFocusColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyMetalButtonUI ui = new MyMetalButtonUI();
        harness.check(ui.getFocusColor(), MetalLookAndFeel.getFocusColor());
    }
}

