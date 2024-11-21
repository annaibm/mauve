/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JDesktopPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JDesktopPane;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JDesktopPane p = new JDesktopPane();
        harness.check(p.isOpaque(), true);
        harness.check(p.getLayout(), null);
    }
}

