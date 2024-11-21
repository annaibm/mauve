/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setMaximum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getMinimum(), 5);
        harness.check(slider.getMaximum(), 10);
        harness.check(slider.getValue(), 7);
        slider.setMaximum(99);
        harness.check(slider.getMinimum(), 5);
        harness.check(slider.getMaximum(), 99);
        harness.check(slider.getValue(), 7);
        slider.setMaximum(3);
        harness.check(slider.getMinimum(), 3);
        harness.check(slider.getMaximum(), 3);
        harness.check(slider.getValue(), 3);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setMaximum(4);
        harness.check(listener1.event.getSource(), slider);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), new Integer(3));
        harness.check(listener2.event.getNewValue(), new Integer(4));
        harness.check(listener2.event.getPropertyName(), (Object)"maximum");
        harness.check(listener2.event.getPropagationId(), null);
        listener1.event = null;
        slider.setMaximum(4);
        harness.check(listener1.event, null);
    }
}

