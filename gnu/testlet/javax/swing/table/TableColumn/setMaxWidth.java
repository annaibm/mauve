/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableColumn;

public class setMaxWidth
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        harness.check(c.getMaxWidth(), Integer.MAX_VALUE);
        c.addPropertyChangeListener(this);
        c.setMaxWidth(99);
        harness.check(c.getMaxWidth(), 99);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"maxWidth");
        harness.check(e.getOldValue(), new Integer(Integer.MAX_VALUE));
        harness.check(e.getNewValue(), new Integer(99));
        this.events.clear();
        harness.check(c.getWidth(), 75);
        harness.check(c.getPreferredWidth(), 75);
        c.setMaxWidth(50);
        harness.check(c.getWidth(), 50);
        harness.check(c.getMaxWidth(), 50);
        harness.check(c.getPreferredWidth(), 50);
        harness.check(this.events.size(), 3);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"width");
        harness.check(e1.getOldValue(), new Integer(75));
        harness.check(e1.getNewValue(), new Integer(50));
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"preferredWidth");
        harness.check(e2.getOldValue(), new Integer(75));
        harness.check(e2.getNewValue(), new Integer(50));
        PropertyChangeEvent e3 = (PropertyChangeEvent)this.events.get(2);
        harness.check(e3.getPropertyName(), (Object)"maxWidth");
        harness.check(e3.getOldValue(), new Integer(99));
        harness.check(e3.getNewValue(), new Integer(50));
    }
}

