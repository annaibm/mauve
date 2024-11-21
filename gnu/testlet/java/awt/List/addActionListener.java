/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.List;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addActionListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        List list2 = new List(10);
        list2.setBackground(Color.blue);
        ActionListener[] actionListeners = list2.getActionListeners();
        harness.check(actionListeners.length, 0);
        list2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }

            public String toString() {
                return "myActionListener";
            }
        });
        actionListeners = list2.getActionListeners();
        harness.check(actionListeners.length, 1);
        harness.check(actionListeners[0].toString(), (Object)"myActionListener");
    }
}

