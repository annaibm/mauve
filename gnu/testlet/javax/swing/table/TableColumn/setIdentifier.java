/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.TableColumn;

public class setIdentifier
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        harness.check(c.getIdentifier(), null);
        c.addPropertyChangeListener(this);
        c.setIdentifier(new Integer(99));
        harness.check(c.getIdentifier(), new Integer(99));
        harness.check(this.event.getPropertyName(), (Object)"identifier");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), new Integer(99));
        c.setIdentifier(null);
        harness.check(c.getIdentifier(), null);
        harness.check(this.event.getPropertyName(), (Object)"identifier");
        harness.check(this.event.getOldValue(), new Integer(99));
        harness.check(this.event.getNewValue(), null);
    }
}

