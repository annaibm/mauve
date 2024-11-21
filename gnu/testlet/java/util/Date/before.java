/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;

public class before
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Date d1 = new Date(-1L);
        Date d2 = new Date(0L);
        Date d3 = new Date(1L);
        harness.check(!d1.before(d1));
        harness.check(d1.before(d2));
        harness.check(d1.before(d3));
        harness.check(!d2.before(d1));
        harness.check(!d2.before(d2));
        harness.check(d2.before(d3));
        harness.check(!d3.before(d1));
        harness.check(!d3.before(d2));
        harness.check(!d3.before(d3));
        boolean pass = false;
        try {
            d1.before(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

