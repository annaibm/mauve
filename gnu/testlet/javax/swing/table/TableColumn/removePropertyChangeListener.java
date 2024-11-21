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

public class removePropertyChangeListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        Listener l1 = new Listener();
        c.addPropertyChangeListener(l1);
        c.setWidth(60);
        harness.check(l1.events.size(), 1);
        c.removePropertyChangeListener(l1);
        l1.events.clear();
        c.setWidth(61);
        harness.check(l1.events.size(), 0);
        PropertyChangeListener[] listeners = c.getPropertyChangeListeners();
        harness.check(listeners.length, 0);
        c.addPropertyChangeListener(l1);
        c.removePropertyChangeListener(new Listener());
        listeners = c.getPropertyChangeListeners();
        harness.check(listeners.length, 1);
        c.removePropertyChangeListener(null);
        listeners = c.getPropertyChangeListeners();
        harness.check(listeners.length, 1);
        c.removePropertyChangeListener(l1);
        listeners = c.getPropertyChangeListeners();
        harness.check(listeners.length, 0);
    }

    static class Listener
    implements PropertyChangeListener {
        public List events = new ArrayList();

        Listener() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            this.events.add(e);
        }
    }
}

