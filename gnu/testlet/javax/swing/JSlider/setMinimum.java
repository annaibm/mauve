/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setMinimum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getMinimum(), 5);
        harness.check(slider.getMaximum(), 10);
        harness.check(slider.getValue(), 7);
        slider.setMinimum(-5);
        harness.check(slider.getMinimum(), -5);
        harness.check(slider.getMaximum(), 10);
        harness.check(slider.getValue(), 7);
        slider.setMinimum(99);
        harness.check(slider.getMinimum(), 99);
        harness.check(slider.getMaximum(), 99);
        harness.check(slider.getValue(), 99);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setMinimum(10);
        harness.check(listener1.event.getSource(), slider);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), new Integer(99));
        harness.check(listener2.event.getNewValue(), new Integer(10));
        harness.check(listener2.event.getPropertyName(), (Object)"minimum");
        harness.check(listener2.event.getPropagationId(), null);
        listener1.event = null;
        listener2.event = null;
        slider.setMinimum(10);
        harness.check(listener1.event, null);
        harness.check(listener2.event, null);
    }
}

