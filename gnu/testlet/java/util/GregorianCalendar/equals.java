/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        long millis = System.currentTimeMillis();
        GregorianCalendar c1 = new GregorianCalendar();
        GregorianCalendar c2 = new GregorianCalendar();
        c1.setTimeInMillis(millis);
        c2.setTimeInMillis(millis);
        harness.check(c1.equals(c2));
        harness.check(c2.equals(c1));
        c1.setTimeInMillis(0L);
        harness.check(!c1.equals(c2));
        c2.setTimeInMillis(0L);
        harness.check(c1.equals(c2));
        c1.setGregorianChange(new Date(Long.MIN_VALUE));
        harness.check(!c1.equals(c2));
        c2.setGregorianChange(new Date(Long.MIN_VALUE));
        harness.check(c1.equals(c2));
        c1.setFirstDayOfWeek(4);
        harness.check(!c1.equals(c2));
        c2.setFirstDayOfWeek(4);
        harness.check(c1.equals(c2));
        c1.setLenient(!c1.isLenient());
        harness.check(!c1.equals(c2));
        c2.setLenient(c1.isLenient());
        harness.check(c1.equals(c2));
        c1.setMinimalDaysInFirstWeek(6);
        harness.check(!c1.equals(c2));
        c2.setMinimalDaysInFirstWeek(6);
        harness.check(c1.equals(c2));
        c1.setTimeZone(new SimpleTimeZone(123, "123"));
        harness.check(!c1.equals(c2));
        c2.setTimeZone(new SimpleTimeZone(123, "123"));
        harness.check(c1.equals(c2));
    }
}

