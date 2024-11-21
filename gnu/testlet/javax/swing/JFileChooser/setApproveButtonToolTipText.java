/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setApproveButtonToolTipText
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
        harness.check(jfc.getApproveButtonToolTipText(), null);
        jfc.setApproveButtonToolTipText("XYZ");
        harness.check(jfc.getApproveButtonToolTipText(), (Object)"XYZ");
        harness.check(this.event.getPropertyName(), (Object)"ApproveButtonToolTipTextChangedProperty");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), (Object)"XYZ");
        jfc.setApproveButtonToolTipText(null);
        harness.check(jfc.getApproveButtonToolTipText(), null);
        harness.check(this.event.getPropertyName(), (Object)"ApproveButtonToolTipTextChangedProperty");
        harness.check(this.event.getOldValue(), (Object)"XYZ");
        harness.check(this.event.getNewValue(), null);
    }
}

