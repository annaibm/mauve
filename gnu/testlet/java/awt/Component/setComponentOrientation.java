/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.ComponentOrientation;
import java.awt.Label;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class setComponentOrientation
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
        harness.check(c.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        c.addPropertyChangeListener(this);
        c.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(c.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), c);
        harness.check(e.getPropertyName(), (Object)"componentOrientation");
        harness.check(e.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        this.events.clear();
        c.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(this.events.size(), 0);
        c.setComponentOrientation(null);
        harness.check(c.getComponentOrientation(), null);
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), c);
        harness.check(e.getPropertyName(), (Object)"componentOrientation");
        harness.check(e.getOldValue(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(e.getNewValue(), null);
    }
}

