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

public class setCellRenderer
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event = null;

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        c.setCellRenderer(r1);
        harness.check(c.getCellRenderer(), r1);
        c.addPropertyChangeListener(this);
        DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
        c.setCellRenderer(r2);
        harness.check(this.event.getPropertyName(), (Object)"cellRenderer");
        harness.check(this.event.getOldValue(), r1);
        harness.check(this.event.getNewValue(), r2);
        c.setCellRenderer(null);
        harness.check(c.getCellRenderer(), null);
        harness.check(this.event.getPropertyName(), (Object)"cellRenderer");
        harness.check(this.event.getOldValue(), r2);
        harness.check(this.event.getNewValue(), null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }
}

