/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTabbedPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Mnemonic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTabbedPane tabs = new JTabbedPane();
        harness.checkPoint("emptyMnemonic");
        tabs.addTab("foo", new JPanel());
        try {
            tabs.setMnemonicAt(0, 0);
            harness.check(true);
        }
        catch (Throwable t) {
            harness.fail("value of '\\0' should be allowed");
        }
    }
}

