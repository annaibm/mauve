/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setExtent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getMinimum(), 5);
        harness.check(slider.getMaximum(), 10);
        harness.check(slider.getValue(), 7);
        slider.setExtent(2);
        harness.check(slider.getExtent(), 2);
        slider.setExtent(5);
        harness.check(slider.getExtent(), 3);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setExtent(0);
        harness.check(listener1.event.getSource(), slider);
        listener1.event = null;
        harness.check(listener2.event, null);
        slider.setExtent(0);
        harness.check(listener1.event, null);
    }
}

