/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;

public class getPaintLabels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(50, 100);
        harness.check(slider.getPaintLabels(), false);
        slider.setPaintLabels(true);
        harness.check(slider.getPaintLabels(), true);
    }
}

