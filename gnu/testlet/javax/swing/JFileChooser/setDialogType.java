/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setDialogType
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
        harness.check(jfc.getDialogType(), 0);
        jfc.setDialogType(1);
        harness.check(jfc.getDialogType(), 1);
        harness.check(this.event.getPropertyName(), (Object)"DialogTypeChangedProperty");
        harness.check(this.event.getOldValue(), new Integer(0));
        harness.check(this.event.getNewValue(), new Integer(1));
        jfc.setDialogType(2);
        harness.check(jfc.getDialogType(), 2);
        harness.check(this.event.getPropertyName(), (Object)"DialogTypeChangedProperty");
        harness.check(this.event.getOldValue(), new Integer(1));
        harness.check(this.event.getNewValue(), new Integer(2));
    }
}

