/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.TableColumn;

public class setHeaderValue
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event;

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        c.setHeaderValue(new Integer(99));
        harness.check(c.getHeaderValue(), new Integer(99));
        c.addPropertyChangeListener(this);
        c.setHeaderValue("Value");
        harness.check(this.event.getPropertyName(), (Object)"headerValue");
        harness.check(this.event.getOldValue(), new Integer(99));
        harness.check(this.event.getNewValue(), (Object)"Value");
        c.setHeaderValue(null);
        harness.check(c.getHeaderValue(), null);
        harness.check(this.event.getPropertyName(), (Object)"headerValue");
        harness.check(this.event.getOldValue(), (Object)"Value");
        harness.check(this.event.getNewValue(), null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }
}

