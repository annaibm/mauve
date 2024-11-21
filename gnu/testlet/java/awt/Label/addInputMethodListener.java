/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class addInputMethodListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        InputMethodListener[] inputMethodListeners = label.getInputMethodListeners();
        harness.check(inputMethodListeners.length, 0);
        label.addInputMethodListener(new InputMethodListener(){

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
        inputMethodListeners = label.getInputMethodListeners();
        harness.check(inputMethodListeners.length, 1);
        harness.check(inputMethodListeners[0].toString(), (Object)"myInputMethodListener");
    }
}

