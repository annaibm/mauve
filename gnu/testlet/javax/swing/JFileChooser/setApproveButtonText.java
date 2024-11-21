/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setApproveButtonText
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
        harness.check(jfc.getApproveButtonText(), null);
        jfc.setApproveButtonText("XYZ");
        harness.check(jfc.getApproveButtonText(), (Object)"XYZ");
        harness.check(this.event.getPropertyName(), (Object)"ApproveButtonTextChangedProperty");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), (Object)"XYZ");
        jfc.setApproveButtonText(null);
        harness.check(jfc.getApproveButtonText(), null);
        harness.check(this.event.getPropertyName(), (Object)"ApproveButtonTextChangedProperty");
        harness.check(this.event.getOldValue(), (Object)"XYZ");
        harness.check(this.event.getNewValue(), null);
    }
}

