/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class setStartYear
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int offset2 = -21600000;
        int t1 = 18000000;
        int t2 = 21600000;
        int dst = 0x6DDD00;
        SimpleTimeZone z = new SimpleTimeZone(offset2, "Z1", 3, 26, 0, t1, 9, 25, 0, t2, dst);
        z.setStartYear(2010);
        GregorianCalendar c = new GregorianCalendar(z);
        c.set(2004, 3, 25, 8, 0, 0);
        harness.check(!z.inDaylightTime(c.getTime()));
        c.set(2004, 3, 26, 8, 0, 0);
        harness.check(!z.inDaylightTime(c.getTime()));
        c.set(2004, 9, 24, 8, 0, 0);
        harness.check(!z.inDaylightTime(c.getTime()));
        c.set(2004, 9, 25, 8, 0, 0);
        harness.check(!z.inDaylightTime(c.getTime()));
    }
}

