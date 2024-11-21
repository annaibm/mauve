/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.SwingPropertyChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class firePropertyChange
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent lastEvent = null;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("(PropertyChangeEvent)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport(this);
        s.addPropertyChangeListener(this);
        PropertyChangeEvent e = new PropertyChangeEvent("SOURCE", "X", "Y", "Z");
        s.firePropertyChange(e);
        harness.check(this.lastEvent.getSource(), (Object)"SOURCE");
        harness.check(this.lastEvent.getPropertyName(), (Object)"X");
        harness.check(this.lastEvent.getOldValue(), (Object)"Y");
        harness.check(this.lastEvent.getNewValue(), (Object)"Z");
        this.lastEvent = null;
        e = new PropertyChangeEvent("SOURCE", "X", "YY", "YY");
        s.firePropertyChange(e);
        harness.check(this.lastEvent, null);
        this.lastEvent = null;
        e = new PropertyChangeEvent("SOURCE", "X", null, null);
        s.firePropertyChange(e);
        harness.check(this.lastEvent, e);
        this.lastEvent = null;
        boolean pass = false;
        try {
            s.firePropertyChange(null);
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(String, Object, Object)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport("SOURCE");
        s.addPropertyChangeListener(this);
        s.firePropertyChange("X", "Y", "Z");
        harness.check(this.lastEvent.getSource(), (Object)"SOURCE");
        harness.check(this.lastEvent.getPropertyName(), (Object)"X");
        harness.check(this.lastEvent.getOldValue(), (Object)"Y");
        harness.check(this.lastEvent.getNewValue(), (Object)"Z");
        this.lastEvent = null;
        this.lastEvent = null;
        s.firePropertyChange("X", "Z", "Z");
        harness.check(this.lastEvent, null);
    }

    private void test3(TestHarness harness) {
        harness.checkPoint("(String, boolean, boolean)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport("SOURCE");
        s.addPropertyChangeListener(this);
        s.firePropertyChange("X", false, true);
        harness.check(this.lastEvent.getSource(), (Object)"SOURCE");
        harness.check(this.lastEvent.getPropertyName(), (Object)"X");
        harness.check(this.lastEvent.getOldValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getNewValue(), Boolean.TRUE);
        this.lastEvent = null;
        s.firePropertyChange("X", true, true);
        harness.check(this.lastEvent, null);
    }

    private void test4(TestHarness harness) {
        harness.checkPoint("(String, int, int)");
        SwingPropertyChangeSupport s = new SwingPropertyChangeSupport("SOURCE");
        s.addPropertyChangeListener(this);
        s.firePropertyChange("X", 12, 34);
        harness.check(this.lastEvent.getSource(), (Object)"SOURCE");
        harness.check(this.lastEvent.getPropertyName(), (Object)"X");
        harness.check(this.lastEvent.getOldValue(), new Integer(12));
        harness.check(this.lastEvent.getNewValue(), new Integer(34));
        this.lastEvent = null;
        s.firePropertyChange("X", 99, 99);
        harness.check(this.lastEvent, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.lastEvent = e;
    }
}

