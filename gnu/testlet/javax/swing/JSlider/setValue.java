/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getMinimum(), 5);
        harness.check(slider.getMaximum(), 10);
        harness.check(slider.getValue(), 7);
        slider.setValue(6);
        harness.check(slider.getValue(), 6);
        slider.setValue(4);
        harness.check(slider.getValue(), 5);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setValue(6);
        harness.check(listener1.event.getSource(), slider);
        harness.check(listener2.event, null);
        listener1.event = null;
        slider.setValue(6);
        harness.check(listener1.event, null);
    }
}

