/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;

public class getExtent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getExtent(), 0);
        slider.setExtent(2);
        harness.check(slider.getExtent(), 2);
    }
}

