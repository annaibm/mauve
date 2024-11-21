/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicSliderUI.MyBasicSliderUI;
import javax.swing.JSlider;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider();
        MyBasicSliderUI b = new MyBasicSliderUI(slider);
        harness.check(b.getSlider(), null);
        harness.check(b.getFocusColor(), null);
        harness.check(b.getHighlightColor(), null);
        harness.check(b.getShadowColor(), null);
        harness.check(b.getTrackBuffer(), 0);
        harness.check(b.getTickLength(), 8);
        boolean pass = false;
        try {
            b.getThumbSize();
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            new MyBasicSliderUI(null);
        }
        catch (NullPointerException e) {
            pass = false;
        }
        harness.check(pass);
    }
}

