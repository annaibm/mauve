/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class addInputMethodListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        InputMethodListener[] inputMethodListeners = checkbox.getInputMethodListeners();
        harness.check(inputMethodListeners.length, 0);
        checkbox.addInputMethodListener(new InputMethodListener(){

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
        inputMethodListeners = checkbox.getInputMethodListeners();
        harness.check(inputMethodListeners.length, 1);
        harness.check(inputMethodListeners[0].toString(), (Object)"myInputMethodListener");
    }
}

