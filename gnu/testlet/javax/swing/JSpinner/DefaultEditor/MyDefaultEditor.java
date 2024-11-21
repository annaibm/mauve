/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DefaultEditor;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;

public class MyDefaultEditor
extends JSpinner.DefaultEditor {
    public List stateChangeEvents = new ArrayList();
    public List propertyChangeEvents = new ArrayList();

    public MyDefaultEditor(JSpinner spinner) {
        super(spinner);
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        super.stateChanged(event);
        if (this.stateChangeEvents != null) {
            this.stateChangeEvents.add(event);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        super.propertyChange(event);
        if (this.propertyChangeEvents != null) {
            this.propertyChangeEvents.add(event);
        }
    }
}

