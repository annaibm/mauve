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

public class setPreferredWidth
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
        harness.check(c.getPreferredWidth(), 75);
        c.addPropertyChangeListener(this);
        c.setPreferredWidth(55);
        harness.check(c.getPreferredWidth(), 55);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"preferredWidth");
        harness.check(e.getOldValue(), new Integer(75));
        harness.check(e.getNewValue(), new Integer(55));
        c.setPreferredWidth(10);
        harness.check(c.getPreferredWidth(), 15);
        c.setMaxWidth(123);
        harness.check(c.getMaxWidth(), 123);
        c.setPreferredWidth(234);
        harness.check(c.getPreferredWidth(), 123);
    }
}

