/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class addFocusListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        FocusListener[] focusListeners = canvas.getFocusListeners();
        harness.check(focusListeners.length, 0);
        canvas.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
            }

            public String toString() {
                return "myFocusListener";
            }
        });
        focusListeners = canvas.getFocusListeners();
        harness.check(focusListeners.length, 1);
        harness.check(focusListeners[0].toString(), (Object)"myFocusListener");
    }
}

