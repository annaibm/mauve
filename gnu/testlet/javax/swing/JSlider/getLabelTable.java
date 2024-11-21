/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class getLabelTable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(new Integer(1), new JLabel("Label 1"));
        slider.setLabelTable(labels);
        harness.check(slider.getLabelTable(), labels);
        slider.setLabelTable(null);
        harness.check(slider.getLabelTable(), null);
    }
}

