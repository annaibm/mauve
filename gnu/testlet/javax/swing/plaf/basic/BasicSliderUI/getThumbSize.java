/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicSliderUI.MyBasicSliderUI;
import java.awt.Dimension;
import javax.swing.JSlider;

public class getThumbSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider();
        slider.setUI(new MyBasicSliderUI(slider));
        MyBasicSliderUI b = (MyBasicSliderUI)slider.getUI();
        harness.check(b.getThumbSize(), new Dimension(11, 20));
        slider.setOrientation(1);
        harness.check(b.getThumbSize(), new Dimension(20, 11));
    }
}

