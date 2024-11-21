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

public class setVerticalAlignment
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("ABC");
        harness.check(label.getVerticalAlignment(), 0);
        label.addPropertyChangeListener(this);
        label.setVerticalAlignment(1);
        harness.check(label.getVerticalAlignment(), 1);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"verticalAlignment");
        harness.check(e0.getOldValue(), new Integer(0));
        harness.check(e0.getNewValue(), new Integer(1));
        boolean pass = false;
        try {
            label.setVerticalAlignment(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

