/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import java.util.Dictionary;
import javax.swing.JSlider;

public class setPaintLabels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testLabelTable(harness);
    }

    public void testGeneral(TestHarness harness) {
        JSlider slider = new JSlider(50, 100);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        harness.check(slider.getPaintLabels(), true);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), Boolean.FALSE);
        harness.check(listener2.event.getNewValue(), Boolean.TRUE);
        harness.check(listener2.event.getPropertyName(), (Object)"paintLabels");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setPaintLabels(true);
        harness.check(listener2.event, null);
    }

    public void testLabelTable(TestHarness harness) {
        JSlider slider = new JSlider(50, 100);
        slider.setMajorTickSpacing(10);
        harness.check(slider.getLabelTable(), null);
        slider.setPaintLabels(true);
        harness.check(slider.getPaintLabels(), true);
        Dictionary labels = slider.getLabelTable();
        harness.check(labels.size(), 6);
    }
}

