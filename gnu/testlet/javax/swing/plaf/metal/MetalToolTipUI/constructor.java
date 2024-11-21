/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalToolTipUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalToolTipUI.MyMetalToolTipUI;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyMetalToolTipUI ui = new MyMetalToolTipUI();
        harness.check(ui.isAcceleratorHidden(), false);
    }
}

