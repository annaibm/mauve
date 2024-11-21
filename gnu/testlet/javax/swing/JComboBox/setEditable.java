/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComboBox;

public class setEditable
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event;

    @Override
    public void test(TestHarness harness) {
        JComboBox c = new JComboBox();
        c.setEditable(false);
        harness.check(c.isEditable(), false);
        c.addPropertyChangeListener(this);
        c.setEditable(true);
        harness.check(c.isEditable(), true);
        harness.check(this.event.getPropertyName(), (Object)"editable");
        harness.check(this.event.getOldValue(), Boolean.FALSE);
        harness.check(this.event.getNewValue(), Boolean.TRUE);
        c.setEditable(false);
        harness.check(c.isEditable(), false);
        harness.check(this.event.getPropertyName(), (Object)"editable");
        harness.check(this.event.getOldValue(), Boolean.TRUE);
        harness.check(this.event.getNewValue(), Boolean.FALSE);
        this.event = null;
        c.setEditable(false);
        harness.check(this.event == null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }
}

