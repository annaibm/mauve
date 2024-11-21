/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ToolTipManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ToolTipManager;

public class setInitialDelay
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ToolTipManager m = ToolTipManager.sharedInstance();
        m.setInitialDelay(123);
        harness.check(m.getInitialDelay(), 123);
        m.setInitialDelay(0);
        harness.check(m.getInitialDelay(), 0);
        boolean pass = false;
        try {
            m.setInitialDelay(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

