/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class getMinimumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider1 = new JSlider(0);
        BasicSliderUI ui1 = new BasicSliderUI(slider1);
        slider1.setUI(ui1);
        Dimension d1 = ui1.getMinimumSize(slider1);
        harness.check(d1, new Dimension(36, 20));
        slider1.setPaintTicks(true);
        slider1.setMajorTickSpacing(10);
        d1 = ui1.getMinimumSize(slider1);
        harness.check(d1, new Dimension(36, 28));
        JSlider slider2 = new JSlider(1);
        BasicSliderUI ui2 = new BasicSliderUI(slider2);
        slider2.setUI(ui2);
        Dimension d2 = ui2.getMinimumSize(slider2);
        harness.check(d2, new Dimension(20, 36));
        slider2.setPaintTicks(true);
        slider2.setMajorTickSpacing(10);
        d2 = ui2.getMinimumSize(slider2);
        harness.check(d2, new Dimension(28, 36));
        d2 = ui2.getMinimumSize(null);
        harness.check(d2, new Dimension(28, 36));
    }
}

