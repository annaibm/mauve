/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ToolTipManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ToolTipManager;

public class setDismissDelay
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ToolTipManager m = ToolTipManager.sharedInstance();
        m.setDismissDelay(123);
        harness.check(m.getDismissDelay(), 123);
        m.setDismissDelay(0);
        harness.check(m.getDismissDelay(), 0);
        boolean pass = false;
        try {
            m.setDismissDelay(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

