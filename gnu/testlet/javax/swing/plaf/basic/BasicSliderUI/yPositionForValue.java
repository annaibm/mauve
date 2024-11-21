/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicSliderUI.MyBasicSliderUI;
import javax.swing.JSlider;

public class yPositionForValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider1 = new JSlider(1);
        slider1.setBounds(10, 20, 40, 400);
        MyBasicSliderUI ui1 = new MyBasicSliderUI(slider1);
        slider1.setUI(ui1);
        harness.check(ui1.yPositionForValue(0), 394);
        harness.check(ui1.yPositionForValue(50), 200);
        harness.check(ui1.yPositionForValue(100), 5);
        harness.check(ui1.yPositionForValue(150), 5);
        harness.check(ui1.yPositionForValue(-50), 394);
    }
}

