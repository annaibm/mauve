/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class setRowSelectionAllowed
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JTable t = new JTable();
        harness.check(t.getRowSelectionAllowed(), true);
        t.addPropertyChangeListener(this);
        t.setRowSelectionAllowed(false);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent event = (PropertyChangeEvent)this.events.get(0);
        harness.check(event.getSource(), t);
        harness.check(event.getPropertyName(), (Object)"rowSelectionAllowed");
        harness.check(event.getOldValue(), Boolean.TRUE);
        harness.check(event.getNewValue(), Boolean.FALSE);
        this.events.clear();
        t.setRowSelectionAllowed(false);
        harness.check(this.events.size(), 0);
    }
}

