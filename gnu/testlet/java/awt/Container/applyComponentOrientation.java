/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Label;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class applyComponentOrientation
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        Container c = new Container();
        Label l1 = new Label("ABC");
        Container c1 = new Container();
        Label l2 = new Label("DEF");
        Container c2 = new Container();
        Label l3 = new Label("GHI");
        c.add(l1);
        c.add(c1);
        c1.add(l2);
        c1.add(c2);
        c2.add(l3);
        harness.check(c.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        harness.check(c1.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        harness.check(c2.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        harness.check(l1.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        harness.check(l2.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        harness.check(l3.getComponentOrientation(), ComponentOrientation.UNKNOWN);
        c.addPropertyChangeListener(this);
        c1.addPropertyChangeListener(this);
        c2.addPropertyChangeListener(this);
        l1.addPropertyChangeListener(this);
        l2.addPropertyChangeListener(this);
        l3.addPropertyChangeListener(this);
        c.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(c.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(c1.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(c2.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(l1.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(l2.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(l3.getComponentOrientation(), ComponentOrientation.LEFT_TO_RIGHT);
        harness.check(this.events.size(), 6);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), c);
        harness.check(e0.getPropertyName(), (Object)"componentOrientation");
        harness.check(e0.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e0.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e1.getSource(), l1);
        harness.check(e1.getPropertyName(), (Object)"componentOrientation");
        harness.check(e1.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e1.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(2);
        harness.check(e2.getSource(), c1);
        harness.check(e2.getPropertyName(), (Object)"componentOrientation");
        harness.check(e2.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e2.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        PropertyChangeEvent e3 = (PropertyChangeEvent)this.events.get(3);
        harness.check(e3.getSource(), l2);
        harness.check(e3.getPropertyName(), (Object)"componentOrientation");
        harness.check(e3.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e3.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        PropertyChangeEvent e4 = (PropertyChangeEvent)this.events.get(4);
        harness.check(e4.getSource(), c2);
        harness.check(e4.getPropertyName(), (Object)"componentOrientation");
        harness.check(e4.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e4.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        PropertyChangeEvent e5 = (PropertyChangeEvent)this.events.get(5);
        harness.check(e5.getSource(), l3);
        harness.check(e5.getPropertyName(), (Object)"componentOrientation");
        harness.check(e5.getOldValue(), ComponentOrientation.UNKNOWN);
        harness.check(e5.getNewValue(), ComponentOrientation.LEFT_TO_RIGHT);
        boolean pass = false;
        try {
            c.applyComponentOrientation(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

