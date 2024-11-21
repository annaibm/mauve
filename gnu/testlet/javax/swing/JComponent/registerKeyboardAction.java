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

public class registerKeyboardAction
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(ActionListener, String, KeyStroke, int)");
        MyJComponent c = new MyJComponent();
        ActionListener l1 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        c.registerKeyboardAction(l1, "ABC", KeyStroke.getKeyStroke('a'), 0);
        harness.check(c.getInputMap(0).keys()[0], KeyStroke.getKeyStroke('a'));
        Object link = c.getInputMap(0).get(KeyStroke.getKeyStroke('a'));
        harness.check(c.getActionMap().get(link), link);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(ActionListener, KeyStroke, int)");
        MyJComponent c = new MyJComponent();
        ActionListener l1 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        c.registerKeyboardAction(l1, KeyStroke.getKeyStroke('a'), 0);
        harness.check(c.getInputMap(0).keys()[0], KeyStroke.getKeyStroke('a'));
        Object link = c.getInputMap(0).get(KeyStroke.getKeyStroke('a'));
        harness.check(c.getActionMap().get(link), link);
    }

    static class MyJComponent
    extends JComponent {
    }
}

