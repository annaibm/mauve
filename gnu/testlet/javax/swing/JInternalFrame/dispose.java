/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class dispose
implements Testlet,
InternalFrameListener {
    List events = new ArrayList();

    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("F1");
        f.addInternalFrameListener(this);
        f.dispose();
        harness.check(f.isClosed());
        harness.check(!f.isSelected());
        harness.check(!f.isVisible());
        harness.check(this.events.size(), 1);
        InternalFrameEvent event = (InternalFrameEvent)this.events.get(0);
        harness.check(event.getSource(), f);
        harness.check(event.getID(), 25551);
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent event) {
        this.events.add(event);
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent event) {
        this.events.add(event);
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent event) {
        this.events.add(event);
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent event) {
        this.events.add(event);
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent event) {
        this.events.add(event);
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent event) {
        this.events.add(event);
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent event) {
        this.events.add(event);
    }
}

