/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Label;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class setName
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        Label c = new Label("ABC");
        harness.check(c.getName() != null);
        c.addPropertyChangeListener(this);
        c.setName("XYZ");
        harness.check(c.getName(), (Object)"XYZ");
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), c);
        harness.check(e0.getPropertyName(), (Object)"name");
        harness.check(e0.getOldValue() != null);
        harness.check(e0.getNewValue(), (Object)"XYZ");
        this.events.clear();
        c.setName("XYZ");
        harness.check(this.events.size(), 0);
        c.setName(null);
        harness.check(c.getName(), null);
    }
}

