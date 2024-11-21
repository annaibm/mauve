/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractAction;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.AbstractAction.MyAction;
import javax.swing.ImageIcon;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("AbstractAction()");
        MyAction a1 = new MyAction();
        harness.check(a1.getValue("AcceleratorKey"), null);
        harness.check(a1.getValue("ActionCommandKey"), null);
        harness.check(a1.getValue("Default"), null);
        harness.check(a1.getValue("LongDescription"), null);
        harness.check(a1.getValue("MnemonicKey"), null);
        harness.check(a1.getValue("Name"), null);
        harness.check(a1.getValue("ShortDescription"), null);
        harness.check(a1.getValue("SmallIcon"), null);
        harness.check(a1.isEnabled());
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("AbstractAction(String)");
        MyAction a1 = new MyAction("MyAction");
        harness.check(a1.getValue("AcceleratorKey"), null);
        harness.check(a1.getValue("ActionCommandKey"), null);
        harness.check(a1.getValue("Default"), null);
        harness.check(a1.getValue("LongDescription"), null);
        harness.check(a1.getValue("MnemonicKey"), null);
        harness.check(a1.getValue("Name"), (Object)"MyAction");
        harness.check(a1.getValue("ShortDescription"), null);
        harness.check(a1.getValue("SmallIcon"), null);
        harness.check(a1.isEnabled());
        MyAction a2 = new MyAction(null);
        harness.check(a2.getValue("Name"), null);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("AbstractAction(String, Icon)");
        ImageIcon icon = new ImageIcon();
        MyAction a1 = new MyAction("MyAction", icon);
        harness.check(a1.getValue("AcceleratorKey"), null);
        harness.check(a1.getValue("ActionCommandKey"), null);
        harness.check(a1.getValue("Default"), null);
        harness.check(a1.getValue("LongDescription"), null);
        harness.check(a1.getValue("MnemonicKey"), null);
        harness.check(a1.getValue("Name"), (Object)"MyAction");
        harness.check(a1.getValue("ShortDescription"), null);
        harness.check(a1.getValue("SmallIcon"), icon);
        harness.check(a1.isEnabled());
        MyAction a2 = new MyAction(null, icon);
        harness.check(a2.getValue("Name"), null);
        harness.check(a2.getValue("SmallIcon"), icon);
        MyAction a3 = new MyAction("X", null);
        harness.check(a3.getValue("Name"), (Object)"X");
        harness.check(a3.getValue("SmallIcon"), null);
    }
}

