/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuBar;

public class setMargin
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        harness.check(mb.getMargin(), new Insets(0, 0, 0, 0));
        harness.check(mb.getMargin() != mb.getMargin());
        mb.addPropertyChangeListener(this);
        mb.setMargin(new Insets(1, 2, 3, 4));
        harness.check(mb.getMargin(), new Insets(1, 2, 3, 4));
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), mb);
        harness.check(e.getPropertyName(), (Object)"margin");
        harness.check(e.getNewValue(), new Insets(1, 2, 3, 4));
        harness.check(e.getOldValue(), null);
        this.events.clear();
        mb.setMargin(new Insets(1, 2, 3, 4));
        harness.check(this.events.size(), 0);
        mb.setMargin(null);
        harness.check(mb.getMargin(), new Insets(0, 0, 0, 0));
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), mb);
        harness.check(e.getPropertyName(), (Object)"margin");
        harness.check(e.getNewValue(), null);
        harness.check(e.getOldValue(), new Insets(1, 2, 3, 4));
    }
}

