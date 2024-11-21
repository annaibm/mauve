/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JInternalFrame;

public class setDesktopIcon
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        f.addPropertyChangeListener(this);
        JInternalFrame.JDesktopIcon icon = new JInternalFrame.JDesktopIcon(f);
        f.setDesktopIcon(icon);
        harness.check(f.getDesktopIcon(), icon);
        harness.check(this.lastEvent.getPropertyName(), (Object)"desktopIcon");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getNewValue(), icon);
        harness.check(this.lastEvent.getOldValue() != null);
        this.lastEvent = null;
        f.setDesktopIcon(null);
        harness.check(f.getDesktopIcon(), null);
        harness.check(this.lastEvent.getPropertyName(), (Object)"desktopIcon");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getNewValue(), null);
        harness.check(this.lastEvent.getOldValue(), icon);
        JInternalFrame f2 = new JInternalFrame("F2");
        JInternalFrame.JDesktopIcon icon2 = new JInternalFrame.JDesktopIcon(f2);
        f.setDesktopIcon(icon);
        harness.check(icon2.getInternalFrame(), f2);
    }
}

