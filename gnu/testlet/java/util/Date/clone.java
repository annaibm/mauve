/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Date d1 = new Date(123L);
        Date d2 = null;
        d2 = (Date)d1.clone();
        harness.check(d1 != d2);
        harness.check(d1.getClass().equals(d2.getClass()));
        harness.check(d1.getTime() == d2.getTime());
    }
}

