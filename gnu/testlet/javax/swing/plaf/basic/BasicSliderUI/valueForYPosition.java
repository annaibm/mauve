/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class valueForYPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider1 = new JSlider(1);
        slider1.setBounds(10, 20, 40, 400);
        BasicSliderUI ui1 = new BasicSliderUI(slider1);
        slider1.setUI(ui1);
        harness.check(ui1.valueForYPosition(0), 100);
        harness.check(ui1.valueForYPosition(200), 50);
        harness.check(ui1.valueForYPosition(400), 0);
        harness.check(ui1.valueForYPosition(-50), 100);
        harness.check(ui1.valueForYPosition(450), 0);
    }
}

