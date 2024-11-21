/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class addFocusListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        choice.setBackground(Color.blue);
        FocusListener[] focusListeners = choice.getFocusListeners();
        harness.check(focusListeners.length, 0);
        choice.addFocusListener(new FocusListener(){

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
        focusListeners = choice.getFocusListeners();
        harness.check(focusListeners.length, 1);
        harness.check(focusListeners[0].toString(), (Object)"myFocusListener");
    }
}

