/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class valueForXPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider1 = new JSlider(0);
        slider1.setBounds(10, 20, 400, 40);
        BasicSliderUI ui1 = new BasicSliderUI(slider1);
        slider1.setUI(ui1);
        harness.check(ui1.valueForXPosition(0), 0);
        harness.check(ui1.valueForXPosition(200), 50);
        harness.check(ui1.valueForXPosition(400), 100);
        harness.check(ui1.valueForXPosition(-50), 0);
        harness.check(ui1.valueForXPosition(450), 100);
    }
}

