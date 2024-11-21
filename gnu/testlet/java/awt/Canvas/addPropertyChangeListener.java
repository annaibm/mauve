/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class addPropertyChangeListener
implements Testlet {
    private static final String PROPERTY_CHANGE_LISTENER_NAME = "myProperlyChangeListener";

    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        PropertyChangeListener[] properlyChangeListeners = canvas.getPropertyChangeListeners();
        harness.check(properlyChangeListeners.length, 0);
        canvas.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
            }

            public String toString() {
                return addPropertyChangeListener.PROPERTY_CHANGE_LISTENER_NAME;
            }
        });
        properlyChangeListeners = canvas.getPropertyChangeListeners();
        harness.check(properlyChangeListeners.length, 1);
        harness.check(properlyChangeListeners[0].toString(), (Object)PROPERTY_CHANGE_LISTENER_NAME);
    }
}

