/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.TableColumn;

public class setResizable
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        harness.check(c.getResizable(), true);
        c.addPropertyChangeListener(this);
        c.setResizable(false);
        harness.check(c.getResizable(), false);
        harness.check(this.lastEvent.getPropertyName(), (Object)"isResizable");
        harness.check(this.lastEvent.getOldValue(), Boolean.TRUE);
        harness.check(this.lastEvent.getNewValue(), Boolean.FALSE);
        this.lastEvent = null;
        c.setResizable(false);
        harness.check(this.lastEvent == null);
        c.setResizable(true);
        harness.check(c.getResizable(), true);
        harness.check(this.lastEvent.getPropertyName(), (Object)"isResizable");
        harness.check(this.lastEvent.getOldValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getNewValue(), Boolean.TRUE);
    }
}

