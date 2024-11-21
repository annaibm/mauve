/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import junit.framework.TestCase;

public class firePropertyChange
extends TestCase
implements PropertyChangeListener {
    private PropertyChangeSupport change;
    private ArrayList events;

    @Override
    public void setUp() {
        this.change = new PropertyChangeSupport(this);
        this.change.addPropertyChangeListener(this);
        this.events = new ArrayList();
    }

    @Override
    public void tearDown() {
        this.change = null;
        this.events = null;
    }

    public void testNullNull() {
        this.change.firePropertyChange("test", null, null);
        firePropertyChange.assertEquals(this.events.size(), 1);
        PropertyChangeEvent ev = (PropertyChangeEvent)this.events.get(0);
        firePropertyChange.assertEquals(ev.getPropertyName(), "test");
        firePropertyChange.assertNull(ev.getNewValue());
        firePropertyChange.assertNull(ev.getOldValue());
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }
}

