/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSlider.MyChangeListener;
import gnu.testlet.javax.swing.JSlider.MyPropertyChangeListener;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class setLabelTable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(new Integer(1), new JLabel("Label 1"));
        slider.setLabelTable(labels);
        harness.check(slider.getLabelTable(), labels);
        MyChangeListener listener1 = new MyChangeListener();
        slider.addChangeListener(listener1);
        MyPropertyChangeListener listener2 = new MyPropertyChangeListener();
        slider.addPropertyChangeListener(listener2);
        Hashtable<Integer, JLabel> labels2 = new Hashtable<Integer, JLabel>();
        labels2.put(new Integer(2), new JLabel("Label 2"));
        slider.setLabelTable(labels2);
        harness.check(listener1.event, null);
        harness.check(listener2.event.getSource(), slider);
        harness.check(listener2.event.getOldValue(), labels);
        harness.check(listener2.event.getNewValue(), labels2);
        harness.check(listener2.event.getPropertyName(), (Object)"labelTable");
        harness.check(listener2.event.getPropagationId(), null);
        listener2.event = null;
        slider.setLabelTable(labels2);
        harness.check(listener2.event, null);
        slider.setLabelTable(null);
        harness.check(slider.getLabelTable(), null);
        boolean pass = false;
        Hashtable<String, String> labelTable = new Hashtable<String, String>();
        ((Dictionary)labelTable).put("a", "b");
        try {
            slider.setLabelTable(labelTable);
            pass = true;
        }
        catch (ClassCastException classCastException) {
            // empty catch block
        }
        harness.check(pass);
    }
}

