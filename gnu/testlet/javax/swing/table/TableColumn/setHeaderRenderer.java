/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class setHeaderRenderer
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event;

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        c.setHeaderRenderer(r);
        harness.check(c.getHeaderRenderer(), r);
        c.addPropertyChangeListener(this);
        DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
        c.setHeaderRenderer(r2);
        harness.check(this.event.getPropertyName(), (Object)"headerRenderer");
        harness.check(this.event.getOldValue(), r);
        harness.check(this.event.getNewValue(), r2);
        c.setHeaderRenderer(null);
        harness.check(this.event.getPropertyName(), (Object)"headerRenderer");
        harness.check(this.event.getOldValue(), r2);
        harness.check(this.event.getNewValue(), null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }
}

