/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class getNextValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        SpinnerNumberModel m = new SpinnerNumberModel(2.0, 1.0, 3.0, 0.5);
        JSpinner s = new JSpinner(m);
        harness.check(s.getValue(), new Double(2.0));
        harness.check(s.getNextValue(), new Double(2.5));
        harness.check(s.getValue(), new Double(2.0));
        s.setValue(new Double(2.5));
        harness.check(s.getNextValue(), new Double(3.0));
        s.setValue(new Double(3.0));
        harness.check(s.getNextValue(), null);
    }
}

