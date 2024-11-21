/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setApproveButtonMnemonic
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
        harness.check(jfc.getApproveButtonMnemonic(), 0);
        jfc.setApproveButtonMnemonic(79);
        harness.check(jfc.getApproveButtonMnemonic(), 79);
        harness.check(this.event.getPropertyName(), (Object)"ApproveButtonMnemonicChangedProperty");
        harness.check(this.event.getOldValue(), new Integer(0));
        harness.check(this.event.getNewValue(), new Integer(79));
        jfc.setApproveButtonMnemonic(0);
        harness.check(jfc.getApproveButtonMnemonic(), 0);
        harness.check(this.event.getPropertyName(), (Object)"ApproveButtonMnemonicChangedProperty");
        harness.check(this.event.getOldValue(), new Integer(79));
        harness.check(this.event.getNewValue(), new Integer(0));
    }
}

