/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class setIconTextGap
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();
    int iconTextGapAtEventTime;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
        JLabel label = (JLabel)e.getSource();
        this.iconTextGapAtEventTime = label.getIconTextGap();
    }

    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("ABC");
        label.addPropertyChangeListener(this);
        label.setIconTextGap(7);
        harness.check(label.getIconTextGap(), 7);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), label);
        harness.check(e.getPropertyName(), (Object)"iconTextGap");
        harness.check(e.getOldValue(), new Integer(0));
        harness.check(e.getNewValue(), new Integer(7));
        harness.check(this.iconTextGapAtEventTime, 7);
    }
}

