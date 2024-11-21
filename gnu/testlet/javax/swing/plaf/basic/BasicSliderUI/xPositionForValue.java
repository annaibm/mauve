/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicSliderUI.MyBasicSliderUI;
import javax.swing.JSlider;

public class xPositionForValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider1 = new JSlider(0);
        slider1.setBounds(10, 20, 400, 40);
        MyBasicSliderUI ui1 = new MyBasicSliderUI(slider1);
        slider1.setUI(ui1);
        harness.check(ui1.xPositionForValue(0), 5);
        harness.check(ui1.xPositionForValue(50), 200);
        harness.check(ui1.xPositionForValue(100), 394);
        harness.check(ui1.xPositionForValue(150), 394);
        harness.check(ui1.xPositionForValue(-50), 5);
    }
}

