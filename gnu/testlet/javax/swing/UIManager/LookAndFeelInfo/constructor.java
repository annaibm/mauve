/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager.LookAndFeelInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UIManager.LookAndFeelInfo lafi = new UIManager.LookAndFeelInfo("name", "class.name");
        harness.check(lafi.getName(), (Object)"name");
        harness.check(lafi.getClassName(), (Object)"class.name");
        lafi = new UIManager.LookAndFeelInfo(null, "class.name");
        harness.check(lafi.getName(), null);
        lafi = new UIManager.LookAndFeelInfo("name", null);
        harness.check(lafi.getClassName(), null);
    }
}

