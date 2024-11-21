/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.SwingPropertyChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class addPropertyChangeListener
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
        s.addPropertyChangeListener(null);
        listeners = s.getPropertyChangeListeners();
        harness.check(listeners.length, 1);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(String, PropertyChangeListener)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        s.addPropertyChangeListener("X", this);
        PropertyChangeListener[] listeners = s.getPropertyChangeListeners("X");
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        s.addPropertyChangeListener("X", null);
        listeners = s.getPropertyChangeListeners("X");
        harness.check(listeners.length, 1);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
    }
}

