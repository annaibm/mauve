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

public class setMinWidth
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
        harness.check(c.getMinWidth(), 15);
        c.addPropertyChangeListener(this);
        c.setMinWidth(11);
        harness.check(c.getMinWidth(), 11);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"minWidth");
        harness.check(e.getOldValue(), new Integer(15));
        harness.check(e.getNewValue(), new Integer(11));
        this.events.clear();
        harness.check(c.getWidth(), 75);
        harness.check(c.getPreferredWidth(), 75);
        c.setMinWidth(88);
        harness.check(c.getMinWidth(), 88);
        harness.check(c.getWidth(), 88);
        harness.check(c.getPreferredWidth(), 88);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"width");
        harness.check(e1.getOldValue(), new Integer(75));
        harness.check(e1.getNewValue(), new Integer(88));
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"preferredWidth");
        harness.check(e2.getOldValue(), new Integer(75));
        harness.check(e2.getNewValue(), new Integer(88));
        PropertyChangeEvent e3 = (PropertyChangeEvent)this.events.get(2);
        harness.check(e3.getPropertyName(), (Object)"minWidth");
        harness.check(e3.getOldValue(), new Integer(11));
        harness.check(e3.getNewValue(), new Integer(88));
        c.setMinWidth(-1);
        harness.check(c.getMinWidth(), 0);
    }
}

