/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;

public class getMaximum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getMinimum(), 5);
        harness.check(slider.getMaximum(), 10);
        harness.check(slider.getValue(), 7);
        slider.setMaximum(99);
        harness.check(slider.getMaximum(), 99);
    }
}

