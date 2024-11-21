/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class addFocusListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        FocusListener[] focusListeners = label.getFocusListeners();
        harness.check(focusListeners.length, 0);
        label.addFocusListener(new FocusListener(){

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
        focusListeners = label.getFocusListeners();
        harness.check(focusListeners.length, 1);
        harness.check(focusListeners[0].toString(), (Object)"myFocusListener");
    }
}

