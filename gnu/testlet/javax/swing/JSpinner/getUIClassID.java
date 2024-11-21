/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSpinner;

public class getUIClassID
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        JSpinner s = new JSpinner();
        harness.check(s.getUIClassID(), (Object)"SpinnerUI");
    }
}

