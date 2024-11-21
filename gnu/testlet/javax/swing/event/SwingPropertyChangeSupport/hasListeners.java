/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.SwingPropertyChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class hasListeners
implements Testlet,
PropertyChangeListener {
    @Override
    public void test(TestHarness harness) {
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        harness.check(s.hasListeners("X"), false);
        s.addPropertyChangeListener(this);
        harness.check(s.hasListeners("X"));
        s.removePropertyChangeListener(this);
        harness.check(s.hasListeners("X"), false);
        s.addPropertyChangeListener("X", this);
        harness.check(s.hasListeners("X"), true);
        s.removePropertyChangeListener("X", this);
        harness.check(s.hasListeners("X"), false);
        harness.check(s.hasListeners(null), false);
        s.addPropertyChangeListener(this);
        harness.check(s.hasListeners(null));
        s.removePropertyChangeListener(this);
        harness.check(s.hasListeners(null), false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
    }
}

