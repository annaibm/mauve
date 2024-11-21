/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setMinorTickSpacing
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(50, 100);
        slider.setMinorTickSpacing(5);
        harness.check(slider.getMinorTickSpacing(), 5);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setMinorTickSpacing(2);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), new Integer(5));
        harness.check(listener2.event.getNewValue(), new Integer(2));
        harness.check(listener2.event.getPropertyName(), (Object)"minorTickSpacing");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setMinorTickSpacing(2);
        harness.check(listener2.event, null);
    }
}

