/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setOrientation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setOrientation(1);
        harness.check(slider.getOrientation(), 1);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), new Integer(0));
        harness.check(listener2.event.getNewValue(), new Integer(1));
        harness.check(listener2.event.getPropertyName(), (Object)"orientation");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setOrientation(1);
        harness.check(listener2.event, null);
        boolean pass = false;
        try {
            slider.setOrientation(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

