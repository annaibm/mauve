/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.SwingPropertyChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class constructor
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event = null;

    @Override
    public void test(TestHarness harness) {
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        s.addPropertyChangeListener(this);
        s.firePropertyChange("X", false, true);
        harness.check(this.event.getSource(), this);
        boolean pass = false;
        try {
            s = new SwingPropertyChangeSupport(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }
}

