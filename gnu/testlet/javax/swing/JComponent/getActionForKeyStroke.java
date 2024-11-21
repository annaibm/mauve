/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class getActionForKeyStroke
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJComponent c = new MyJComponent();
        KeyStroke ks = KeyStroke.getKeyStroke('a');
        ActionListener a1 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        ActionListener a2 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        ActionListener a3 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        harness.check(c.getActionForKeyStroke(ks), null);
        c.registerKeyboardAction(a1, ks, 2);
        harness.check(c.getActionForKeyStroke(ks), a1);
        c.registerKeyboardAction(a2, ks, 1);
        harness.check(c.getActionForKeyStroke(ks), a2);
        c.registerKeyboardAction(a3, ks, 0);
        harness.check(c.getActionForKeyStroke(ks), a3);
        harness.check(c.getActionForKeyStroke(null), null);
    }

    static class MyJComponent
    extends JComponent {
    }
}

