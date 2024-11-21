/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;

public class setCurrentDirectory
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        fc.addPropertyChangeListener(this);
        harness.check(fc.getCurrentDirectory(), new File(System.getProperty("user.home")));
        File d = new File(harness.getTempDirectory());
        fc.setCurrentDirectory(d);
        harness.check(fc.getCurrentDirectory(), d);
        harness.check(this.event.getPropertyName(), (Object)"directoryChanged");
        harness.check(this.event.getOldValue(), new File(System.getProperty("user.home")));
        harness.check(this.event.getNewValue(), d);
        fc.setCurrentDirectory(null);
        harness.check(fc.getCurrentDirectory(), new File(System.getProperty("user.home")));
        harness.check(this.event.getPropertyName(), (Object)"directoryChanged");
        harness.check(this.event.getOldValue(), d);
        harness.check(this.event.getNewValue(), new File(System.getProperty("user.home")));
    }
}

