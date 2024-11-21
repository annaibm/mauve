/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class getOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    private void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int, int)");
        int offset2 = -21600000;
        int t1 = 18000000;
        int t2 = 21600000;
        int dst = 0x6DDD00;
        SimpleTimeZone z = new SimpleTimeZone(offset2, "Z1", 3, 26, 0, t1, 9, 25, 0, t2, dst);
        harness.check(z.getOffset(1, 2004, 3, 26, 2, t1 - 1000), offset2);
        harness.check(z.getOffset(1, 2004, 3, 26, 2, t1 + 1000), offset2 + dst);
        harness.check(z.getOffset(1, 2004, 9, 25, 2, t2 - dst - 1000), offset2 + dst);
        harness.check(z.getOffset(1, 2004, 9, 25, 2, t2 - dst + 1000), offset2);
    }

    private void testMethod2(TestHarness harness) {
        harness.checkPoint("(Date)");
        int offset2 = -21600000;
        int t1 = 18000000;
        int t2 = 21600000;
        int dst = 0x6DDD00;
        SimpleTimeZone z = new SimpleTimeZone(offset2, "Z1", 3, 26, 0, t1, 9, 25, 0, t2, dst);
        GregorianCalendar c = new GregorianCalendar(z);
        c.set(2004, 3, 26, 4, 59, 59);
        long d1 = c.getTimeInMillis();
        harness.check(z.getOffset(d1), offset2);
        harness.check(z.getOffset(d1 + 2000L), offset2 + dst);
    }
}

