/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyPropertyChangeListener
implements PropertyChangeListener {
    boolean change = false;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.change = true;
    }

    public boolean getChange() {
        return this.change;
    }

    public void setChange(boolean flag) {
        this.change = flag;
    }
}

