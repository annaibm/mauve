/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addActionListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button = new Button("xyzzy");
        button.setBackground(Color.blue);
        ActionListener[] actionListeners = button.getActionListeners();
        harness.check(actionListeners.length, 0);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }

            public String toString() {
                return "myActionListener";
            }
        });
        actionListeners = button.getActionListeners();
        harness.check(actionListeners.length, 1);
        harness.check(actionListeners[0].toString(), (Object)"myActionListener");
    }
}

