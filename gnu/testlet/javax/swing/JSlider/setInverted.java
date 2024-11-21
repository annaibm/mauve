/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setInverted
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        slider.setInverted(true);
        harness.check(slider.getInverted(), true);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setInverted(false);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), Boolean.TRUE);
        harness.check(listener2.event.getNewValue(), Boolean.FALSE);
        harness.check(listener2.event.getPropertyName(), (Object)"inverted");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setInverted(false);
        harness.check(listener2.event, null);
    }
}

