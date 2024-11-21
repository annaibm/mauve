/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Container;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.util.EventListener;

public class getListeners
implements Testlet,
ContainerListener {
    @Override
    public void test(TestHarness harness) {
        TestContainer c = new TestContainer();
        c.addContainerListener(this);
        EventListener[] listeners = c.getListeners(ContainerListener.class);
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        listeners = c.getListeners(FocusListener.class);
        harness.check(listeners.length, 0);
        c.removeContainerListener(this);
        listeners = c.getListeners(ContainerListener.class);
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
    public void componentAdded(ContainerEvent e) {
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
    }

    class TestContainer
    extends Container {
        TestContainer() {
        }
    }
}

