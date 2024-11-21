/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerDateModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;
import javax.swing.SpinnerDateModel;

public class getNextValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Date now = new Date();
        Date next2 = new Date(now.getTime() + 1L);
        Date start = new Date(now.getTime() - 2L);
        Date end2 = new Date(now.getTime() + 2L);
        SpinnerDateModel m = new SpinnerDateModel(now, start, end2, 14);
        harness.check(m.getValue(), now);
        harness.check(m.getNextValue(), next2);
        harness.check(m.getValue(), now);
        m.setValue(next2);
        harness.check(m.getNextValue(), end2);
        m.setValue(end2);
        harness.check(m.getNextValue(), null);
        m = new SpinnerDateModel(now, null, null, 14);
        harness.check(m.getValue(), now);
        harness.check(m.getNextValue(), next2);
        harness.check(m.getValue(), now);
    }
}

