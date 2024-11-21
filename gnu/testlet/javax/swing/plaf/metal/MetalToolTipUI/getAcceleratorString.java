/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalToolTipUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JButton;
import javax.swing.JToolTip;
import javax.swing.plaf.metal.MetalToolTipUI;

public class getAcceleratorString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JButton button1 = new JButton("Test 1");
        button1.setMnemonic(66);
        JToolTip t1 = button1.createToolTip();
        MetalToolTipUI ui1 = (MetalToolTipUI)t1.getUI();
        harness.check(ui1.getAcceleratorString(), (Object)"Alt-B");
        JButton button2 = new JButton("Test 2");
        button2.setMnemonic(67);
        JToolTip t2 = button2.createToolTip();
        MetalToolTipUI ui2 = (MetalToolTipUI)t2.getUI();
        harness.check(ui2.getAcceleratorString(), (Object)"Alt-C");
        harness.check(ui1.getAcceleratorString(), (Object)"Alt-C");
        harness.check(ui1 == ui2);
    }
}

