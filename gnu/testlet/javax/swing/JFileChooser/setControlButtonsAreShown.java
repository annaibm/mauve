/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setControlButtonsAreShown
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
        harness.check(jfc.getControlButtonsAreShown(), true);
        jfc.setControlButtonsAreShown(false);
        harness.check(jfc.getControlButtonsAreShown(), false);
        harness.check(this.event.getPropertyName(), (Object)"ControlButtonsAreShownChangedProperty");
        harness.check(this.event.getOldValue(), Boolean.TRUE);
        harness.check(this.event.getNewValue(), Boolean.FALSE);
        jfc.setControlButtonsAreShown(true);
        harness.check(jfc.getControlButtonsAreShown(), true);
        harness.check(this.event.getPropertyName(), (Object)"ControlButtonsAreShownChangedProperty");
        harness.check(this.event.getOldValue(), Boolean.FALSE);
        harness.check(this.event.getNewValue(), Boolean.TRUE);
    }
}

