/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalToolTipUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JToolTip;
import javax.swing.plaf.metal.MetalToolTipUI;

public class createUI
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JToolTip t2;
        MetalToolTipUI ui2;
        JToolTip t1 = new JToolTip();
        MetalToolTipUI ui1 = (MetalToolTipUI)MetalToolTipUI.createUI(t1);
        harness.check(ui1 == (ui2 = (MetalToolTipUI)MetalToolTipUI.createUI(t2 = new JToolTip())));
    }
}

