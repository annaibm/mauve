/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;

public class setModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider();
        BoundedRangeModel m1 = slider.getModel();
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        DefaultBoundedRangeModel m2 = new DefaultBoundedRangeModel(3, 0, 1, 6);
        slider.setModel(m2);
        harness.check(slider.getModel(), m2);
        harness.check(slider.getValue(), 3);
        harness.check(slider.getExtent(), 0);
        harness.check(slider.getMinimum(), 1);
        harness.check(slider.getMaximum(), 6);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), m1);
        harness.check(listener2.event.getNewValue(), m2);
        harness.check(listener2.event.getPropertyName(), (Object)"model");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setModel(m2);
        harness.check(listener2.event, null);
        boolean pass = false;
        try {
            slider.setModel(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

