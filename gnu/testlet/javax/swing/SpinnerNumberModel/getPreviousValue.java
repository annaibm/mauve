/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerNumberModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SpinnerNumberModel;

public class getPreviousValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SpinnerNumberModel m = new SpinnerNumberModel(2.0, 1.0, 3.0, 0.5);
        harness.check(m.getValue(), new Double(2.0));
        harness.check(m.getPreviousValue(), new Double(1.5));
        harness.check(m.getValue(), new Double(2.0));
        m.setValue(new Double(1.5));
        harness.check(m.getPreviousValue(), new Double(1.0));
        m.setValue(new Double(1.0));
        harness.check(m.getPreviousValue(), null);
        m = new SpinnerNumberModel(new Integer(0), null, null, new Integer(1));
        harness.check(m.getValue(), new Integer(0));
        harness.check(m.getPreviousValue(), new Integer(-1));
        harness.check(m.getValue(), new Integer(0));
        m.setValue(new Integer(-99));
        harness.check(m.getPreviousValue(), new Integer(-100));
        m.setValue(new Integer(Integer.MIN_VALUE));
        harness.check(m.getPreviousValue(), new Integer(Integer.MAX_VALUE));
    }
}

