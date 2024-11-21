/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.util.EventListener;

public class getListeners
implements Testlet,
ComponentListener {
    @Override
    public void test(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.addComponentListener(this);
        EventListener[] listeners = c.getListeners(ComponentListener.class);
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        listeners = c.getListeners(FocusListener.class);
        harness.check(listeners.length, 0);
        c.removeComponentListener(this);
        listeners = c.getListeners(ComponentListener.class);
        harness.check(listeners.length, 0);
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
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    class TestComponent
    extends Component {
        TestComponent() {
        }
    }
}

