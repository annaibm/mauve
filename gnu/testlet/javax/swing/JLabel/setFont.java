/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class setFont
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
        label.addPropertyChangeListener(this);
        Font f = new Font("Dialog", 0, 15);
        label.setFont(f);
        harness.check(label.getFont(), f);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"font");
        harness.check(e0.getNewValue(), f);
        this.events.clear();
        label.setFont(null);
        harness.check(label.getFont(), null);
        harness.check(this.events.size(), 1);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"font");
        harness.check(e0.getOldValue(), f);
        harness.check(e0.getNewValue(), null);
    }
}

