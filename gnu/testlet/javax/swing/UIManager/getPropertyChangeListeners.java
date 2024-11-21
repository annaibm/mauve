/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.UIManager;

public class getPropertyChangeListeners
implements Testlet,
PropertyChangeListener {
    @Override
    public void test(TestHarness harness) {
        PropertyChangeListener[] listeners = UIManager.getPropertyChangeListeners();
        int count = listeners.length;
        UIManager.addPropertyChangeListener(this);
        listeners = UIManager.getPropertyChangeListeners();
        harness.check(listeners.length, count + 1);
        harness.check(listeners[count], this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
    }
}

