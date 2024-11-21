/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener
implements ChangeListener {
    public ChangeEvent event = null;

    @Override
    public void stateChanged(ChangeEvent event) {
        this.event = event;
    }
}

