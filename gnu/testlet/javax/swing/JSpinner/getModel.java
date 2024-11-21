/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class getModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        JSpinner s = new JSpinner();
        SpinnerDateModel m = new SpinnerDateModel();
        s.setModel(m);
        harness.check(s.getModel(), m);
    }
}

