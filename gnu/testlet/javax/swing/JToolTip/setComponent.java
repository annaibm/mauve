/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolTip;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JToolTip;

public class setComponent
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        JButton component2 = new JButton("Button");
        JToolTip tt = new JToolTip();
        tt.addPropertyChangeListener(this);
        tt.setComponent(component2);
        harness.check(tt.getComponent(), component2);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"component");
        harness.check(e.getSource(), tt);
        harness.check(e.getOldValue(), null);
        harness.check(e.getNewValue(), component2);
        this.events.clear();
        tt.setComponent(null);
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"component");
        harness.check(e.getSource(), tt);
        harness.check(e.getOldValue(), component2);
        harness.check(e.getNewValue(), null);
    }
}

