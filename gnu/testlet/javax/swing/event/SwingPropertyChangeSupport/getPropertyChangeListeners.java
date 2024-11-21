/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.SwingPropertyChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import javax.swing.event.SwingPropertyChangeSupport;

public class getPropertyChangeListeners
implements Testlet,
PropertyChangeListener {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("()");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        PropertyChangeListener[] listeners = s.getPropertyChangeListeners();
        harness.check(listeners.length, 0);
        s.addPropertyChangeListener(this);
        listeners = s.getPropertyChangeListeners();
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        s.addPropertyChangeListener("X", this);
        listeners = s.getPropertyChangeListeners();
        harness.check(listeners.length, 2);
        PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy)listeners[1];
        harness.check(proxy.getPropertyName(), (Object)"X");
        harness.check(proxy.getListener(), this);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(String)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        PropertyChangeListener[] listeners = s.getPropertyChangeListeners("X");
        harness.check(listeners.length, 0);
        s.addPropertyChangeListener("X", this);
        listeners = s.getPropertyChangeListeners("X");
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
    }
}

