/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame.AccessibleJInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleContext;
import javax.swing.JInternalFrame;

public class getAccessibleValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        AccessibleContext ac = f.getAccessibleContext();
        harness.check(ac.getAccessibleValue() == ac);
    }
}

