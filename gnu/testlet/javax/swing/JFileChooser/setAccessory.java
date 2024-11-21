/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class setAccessory
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        jfc.addPropertyChangeListener(this);
        harness.check(jfc.getAccessory(), null);
        JPanel acc1 = new JPanel();
        jfc.setAccessory(acc1);
        harness.check(jfc.getAccessory(), acc1);
        harness.check(this.event.getPropertyName(), (Object)"AccessoryChangedProperty");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), acc1);
        jfc.setAccessory(null);
        harness.check(jfc.getAccessory(), null);
        harness.check(this.event.getPropertyName(), (Object)"AccessoryChangedProperty");
        harness.check(this.event.getOldValue(), acc1);
        harness.check(this.event.getNewValue(), null);
    }
}

