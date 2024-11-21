/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class setPreferredSize
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        Button c = new Button("ABC");
        harness.check(c.getPreferredSize(), new Dimension(0, 0));
        harness.check(c.isPreferredSizeSet(), false);
        c.addPropertyChangeListener(this);
        c.setPreferredSize(new Dimension(10, 20));
        harness.check(c.getPreferredSize(), new Dimension(10, 20));
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"preferredSize");
        harness.check(e.getSource(), c);
        harness.check(e.getOldValue(), null);
        harness.check(e.getNewValue(), new Dimension(10, 20));
        this.events.clear();
        c.setPreferredSize(new Dimension(30, 40));
        harness.check(c.getPreferredSize(), new Dimension(30, 40));
        harness.check(c.isPreferredSizeSet(), true);
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"preferredSize");
        harness.check(e.getSource(), c);
        harness.check(e.getOldValue(), new Dimension(10, 20));
        harness.check(e.getNewValue(), new Dimension(30, 40));
        this.events.clear();
        c.setPreferredSize(null);
        harness.check(c.getPreferredSize(), new Dimension(0, 0));
        harness.check(c.isPreferredSizeSet(), false);
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"preferredSize");
        harness.check(e.getSource(), c);
        harness.check(e.getOldValue(), new Dimension(30, 40));
        harness.check(e.getNewValue(), null);
    }
}

