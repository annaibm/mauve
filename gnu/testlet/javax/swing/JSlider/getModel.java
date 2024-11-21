/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;

public class getModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider();
        DefaultBoundedRangeModel m = new DefaultBoundedRangeModel(3, 0, 1, 6);
        slider.setModel(m);
        harness.check(slider.getModel(), m);
    }
}

