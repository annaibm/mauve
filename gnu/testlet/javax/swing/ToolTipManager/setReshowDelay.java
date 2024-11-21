/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ToolTipManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ToolTipManager;

public class setReshowDelay
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ToolTipManager m = ToolTipManager.sharedInstance();
        m.setInitialDelay(20);
        m.setReshowDelay(123);
        harness.check(m.getReshowDelay(), 123);
        harness.check(m.getInitialDelay(), 20);
        m.setReshowDelay(0);
        harness.check(m.getReshowDelay(), 0);
        boolean pass = false;
        try {
            m.setReshowDelay(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

