/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.AbstractAction.MyAction;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("JMenuItem(Action)");
        MyAction a = new MyAction();
        a.putValue("Name", "Action 1");
        a.putValue("AcceleratorKey", KeyStroke.getKeyStroke('A'));
        a.putValue("MnemonicKey", new Integer(50));
        a.putValue("ActionCommandKey", "ActionCommand");
        JMenuItem item = new JMenuItem(a);
        harness.check(item.getText(), (Object)"Action 1");
        harness.check(item.getAccelerator(), KeyStroke.getKeyStroke('A'));
        harness.check(item.getMnemonic(), 50);
        harness.check(item.getActionCommand(), (Object)"ActionCommand");
        item = new JMenuItem((Action)null);
        harness.check(item.getText(), null);
        harness.check(item.getAccelerator(), null);
        harness.check(item.getMnemonic(), 0);
        harness.check(item.getActionCommand(), null);
    }
}

