/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class addInputMethodListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        InputMethodListener[] inputMethodListeners = canvas.getInputMethodListeners();
        harness.check(inputMethodListeners.length, 0);
        canvas.addInputMethodListener(new InputMethodListener(){

            @Override
            public void caretPositionChanged(InputMethodEvent event) {
            }

            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
            }

            public String toString() {
                return "myInputMethodListener";
            }
        });
        inputMethodListeners = canvas.getInputMethodListeners();
        harness.check(inputMethodListeners.length, 1);
        harness.check(inputMethodListeners[0].toString(), (Object)"myInputMethodListener");
    }
}

