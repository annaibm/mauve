/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setFileHidingEnabled
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
        harness.check(jfc.isFileHidingEnabled(), true);
        jfc.setFileHidingEnabled(false);
        harness.check(jfc.isFileHidingEnabled(), false);
        harness.check(this.event.getPropertyName(), (Object)"FileHidingChanged");
        harness.check(this.event.getOldValue(), Boolean.TRUE);
        harness.check(this.event.getNewValue(), Boolean.FALSE);
        jfc.setFileHidingEnabled(true);
        harness.check(jfc.isFileHidingEnabled(), true);
        harness.check(this.event.getPropertyName(), (Object)"FileHidingChanged");
        harness.check(this.event.getOldValue(), Boolean.FALSE);
        harness.check(this.event.getNewValue(), Boolean.TRUE);
    }
}

