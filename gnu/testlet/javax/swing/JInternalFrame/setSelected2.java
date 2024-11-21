/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class setSelected2
implements Testlet,
PropertyChangeListener,
VetoableChangeListener,
InternalFrameListener {
    PropertyChangeEvent lastEvent;
    PropertyChangeEvent lastVetoableEvent;
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void vetoableChange(PropertyChangeEvent event) {
        this.lastVetoableEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("F1");
        harness.check(!f.isSelected());
        JFrame fr = new JFrame();
        fr.getContentPane().add(f);
        f.setVisible(true);
        fr.pack();
        fr.setVisible(true);
        f.addVetoableChangeListener(this);
        f.addPropertyChangeListener(this);
        f.addInternalFrameListener(this);
        try {
            f.setSelected(true);
        }
        catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        harness.check(f.isSelected());
        harness.check(this.lastVetoableEvent.getPropertyName(), (Object)"selected");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getNewValue(), Boolean.TRUE);
        harness.check(this.lastEvent.getPropertyName(), (Object)"selected");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getNewValue(), Boolean.TRUE);
        harness.check(this.events.size(), 1);
        InternalFrameEvent event = (InternalFrameEvent)this.events.get(0);
        harness.check(event.getSource(), f);
        harness.check(event.getID(), 25554);
        this.events.clear();
        try {
            f.setSelected(true);
        }
        catch (PropertyVetoException propertyVetoException) {
            // empty catch block
        }
        harness.check(f.isSelected());
        harness.check(this.events.size(), 0);
        f.dispose();
        fr.dispose();
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

