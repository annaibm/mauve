/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicSliderUI.MyBasicSliderUI;
import java.awt.Rectangle;
import javax.swing.JSlider;

public class installUI
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider();
        slider.setBounds(10, 20, 300, 40);
        MyBasicSliderUI ui = new MyBasicSliderUI(slider);
        ui.installUI(slider);
        harness.check(ui.getContentRect(), new Rectangle(0, 0, 300, 40));
        harness.check(ui.getTrackBuffer(), 5);
        harness.check(ui.getTrackRect(), new Rectangle(5, 9, 290, 20));
        harness.check(ui.getThumbRect(), new Rectangle(145, 9, 11, 20));
        harness.check(ui.getTickRect(), new Rectangle(5, 28, 290, 0));
    }
}

