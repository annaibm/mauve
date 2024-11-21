/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.SwingPropertyChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class removePropertyChangeListener
implements Testlet,
PropertyChangeListener {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("(PropertyChangeListener)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        s.addPropertyChangeListener(this);
        PropertyChangeListener[] listeners = s.getPropertyChangeListeners();
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        s.removePropertyChangeListener(this);
        listeners = s.getPropertyChangeListeners();
        harness.check(listeners.length, 0);
        s.removePropertyChangeListener(this);
        s.removePropertyChangeListener(null);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(String, PropertyChangeListener)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        s.addPropertyChangeListener("X", this);
        PropertyChangeListener[] listeners = s.getPropertyChangeListeners("X");
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        s.removePropertyChangeListener("X", this);
        listeners = s.getPropertyChangeListeners("X");
        harness.check(listeners.length, 0);
        s.removePropertyChangeListener("X", this);
        boolean pass = false;
        try {
            s.removePropertyChangeListener(null, this);
            pass = true;
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
        s.removePropertyChangeListener("X", null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
    }
}

