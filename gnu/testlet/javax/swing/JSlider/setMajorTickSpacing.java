/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import javax.swing.JSlider;

public class setMajorTickSpacing
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(50, 100);
        slider.setMajorTickSpacing(10);
        harness.check(slider.getMajorTickSpacing(), 10);
        harness.check(slider.getLabelTable(), null);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setMajorTickSpacing(11);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), new Integer(10));
        harness.check(listener2.event.getNewValue(), new Integer(11));
        harness.check(listener2.event.getPropertyName(), (Object)"majorTickSpacing");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setMajorTickSpacing(11);
        harness.check(listener2.event, null);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        harness.check(slider.getLabelTable().size(), 6);
        slider.setMajorTickSpacing(25);
        harness.check(slider.getLabelTable().size(), 6);
    }
}

