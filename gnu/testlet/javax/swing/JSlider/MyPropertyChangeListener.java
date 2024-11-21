/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyPropertyChangeListener
implements PropertyChangeListener {
    public PropertyChangeEvent event = null;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.event = event;
    }
}

