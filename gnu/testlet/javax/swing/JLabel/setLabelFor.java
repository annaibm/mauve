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
import javax.swing.JButton;
import javax.swing.JLabel;

public class setLabelFor
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JButton b = new JButton("ABC");
        JLabel l = new JLabel("XYZ");
        b.addPropertyChangeListener(this);
        l.addPropertyChangeListener(this);
        l.setLabelFor(b);
        harness.check(l.getLabelFor(), b);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent pce1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(pce1.getSource(), l);
        harness.check(pce1.getPropertyName(), (Object)"labelFor");
        harness.check(pce1.getOldValue(), null);
        harness.check(pce1.getNewValue(), b);
        PropertyChangeEvent pce2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(pce2.getSource(), b);
        harness.check(pce2.getPropertyName(), (Object)"labeledBy");
        harness.check(pce2.getOldValue(), null);
        harness.check(pce2.getNewValue(), l);
        harness.check(b.getClientProperty("labeledBy"), l);
        this.events.clear();
        l.setLabelFor(b);
        harness.check(this.events.size(), 0);
        this.events.clear();
        l.setLabelFor(null);
        harness.check(this.events.size(), 2);
    }
}

