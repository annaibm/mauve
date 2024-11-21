/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class setHelpMenu
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        boolean pass = false;
        try {
            mb.setHelpMenu(new JMenu());
        }
        catch (Error e) {
            pass = true;
        }
        harness.check(pass);
    }
}

