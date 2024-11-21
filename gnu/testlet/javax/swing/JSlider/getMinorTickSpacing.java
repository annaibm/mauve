/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;

public class getMinorTickSpacing
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(50, 100);
        slider.setMinorTickSpacing(5);
        harness.check(slider.getMinorTickSpacing(), 5);
    }
}

