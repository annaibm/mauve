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

public class setWidth
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        harness.check(c.getWidth(), 75);
        c.addPropertyChangeListener(this);
        c.setWidth(19);
        harness.check(c.getWidth(), 19);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"width");
        harness.check(e.getOldValue(), new Integer(75));
        harness.check(e.getNewValue(), new Integer(19));
        c.setWidth(10);
        harness.check(c.getWidth(), 15);
        c.setMaxWidth(100);
        c.setWidth(110);
        harness.check(c.getWidth(), 100);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }
}

