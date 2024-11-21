/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;

public class setFileSelectionMode
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
        harness.check(jfc.getFileSelectionMode(), 0);
        jfc.setFileSelectionMode(1);
        harness.check(jfc.getFileSelectionMode(), 1);
        harness.check(this.event.getPropertyName(), (Object)"fileSelectionChanged");
        harness.check(this.event.getOldValue(), new Integer(0));
        harness.check(this.event.getNewValue(), new Integer(1));
        boolean pass = false;
        try {
            jfc.setFileSelectionMode(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

