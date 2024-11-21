/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Date d1 = new Date(100L);
        Date d2 = new Date(100L);
        harness.check(d1.equals(d2));
        harness.check(d2.equals(d1));
        d1 = new Date(101L);
        harness.check(!d1.equals(d2));
        d2 = new Date(101L);
        harness.check(d1.equals(d2));
    }
}

