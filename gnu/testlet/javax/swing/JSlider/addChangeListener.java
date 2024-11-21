/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import javax.swing.JSlider;

public class addChangeListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider();
        MyChangeListener listener = new MyChangeListener();
        slider.addChangeListener(listener);
        slider.setExtent(1);
        harness.check(listener.event.getSource(), slider);
        boolean pass = true;
        try {
            slider.addChangeListener(null);
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
    }
}

