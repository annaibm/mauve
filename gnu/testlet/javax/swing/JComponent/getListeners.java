/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.EventListener;
import javax.swing.JComponent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class getListeners
implements Testlet,
AncestorListener {
    @Override
    public void test(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.addAncestorListener(this);
        EventListener[] listeners = c.getListeners(AncestorListener.class);
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        listeners = c.getListeners(FocusListener.class);
        harness.check(listeners.length, 0);
        c.removeAncestorListener(this);
        listeners = c.getListeners(AncestorListener.class);
        harness.check(listeners.length, 0);
        MyPropertyChangeListener pcl = new MyPropertyChangeListener();
        c.addPropertyChangeListener(pcl);
        listeners = c.getListeners(PropertyChangeListener.class);
        harness.check(listeners.length, 1);
        if (listeners.length > 0) {
            harness.check(listeners[0], pcl);
        } else {
            harness.check(false);
        }
        MyVetoableChangeListener vcl = new MyVetoableChangeListener();
        c.addVetoableChangeListener(vcl);
        listeners = c.getListeners(VetoableChangeListener.class);
        harness.check(listeners.length, 1);
        if (listeners.length > 0) {
            harness.check(listeners[0], vcl);
        } else {
            harness.check(false);
        }
        boolean pass = false;
        try {
            listeners = c.getListeners(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    @Override
    public void ancestorMoved(AncestorEvent e) {
    }

    @Override
    public void ancestorAdded(AncestorEvent e) {
    }

    @Override
    public void ancestorRemoved(AncestorEvent e) {
    }

    class MyVetoableChangeListener
    implements VetoableChangeListener {
        MyVetoableChangeListener() {
        }

        @Override
        public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
        }
    }

    class MyPropertyChangeListener
    implements PropertyChangeListener {
        MyPropertyChangeListener() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
        }
    }

    class TestComponent
    extends JComponent {
        TestComponent() {
        }
    }
}

