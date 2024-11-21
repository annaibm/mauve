/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class inDaylightTime
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        int offset2 = -21600000;
        int t1 = 18000000;
        int t2 = 21600000;
        int dst = 0x6DDD00;
        SimpleTimeZone z = new SimpleTimeZone(offset2, "Z1", 3, 26, 0, t1, 9, 25, 0, t2, dst);
        GregorianCalendar c = new GregorianCalendar(z);
        c.set(2004, 3, 25, 8, 0, 0);
        harness.check(!z.inDaylightTime(c.getTime()));
        c.set(2004, 3, 26, 8, 0, 0);
        harness.check(z.inDaylightTime(c.getTime()));
        c.set(2004, 9, 24, 8, 0, 0);
        harness.check(z.inDaylightTime(c.getTime()));
        c.set(2004, 9, 25, 8, 0, 0);
        harness.check(!z.inDaylightTime(c.getTime()));
        try {
            boolean b = z.inDaylightTime(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void test2(TestHarness harness) {
        SimpleTimeZone utc = new SimpleTimeZone(0, "GMT");
        TimeZone.setDefault(utc);
        Calendar cal = Calendar.getInstance(utc);
        harness.checkPoint("test 1");
        SimpleTimeZone tz1 = new SimpleTimeZone(-12600000, "Canada/Newfoundland", 2, 8, -1, 60000, 10, 1, -1, 60000);
        cal.set(2037, 10, 1, 2, 30, 0);
        harness.check(((TimeZone)tz1).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2037, 10, 1, 2, 31, 0);
        harness.check(!((TimeZone)tz1).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2038, 0, 1, 2, 29, 0);
        harness.check(!((TimeZone)tz1).inDaylightTime(new Date(cal.getTimeInMillis())));
        harness.checkPoint("test 2");
        SimpleTimeZone tz2 = new SimpleTimeZone(-12600000, "Test1", 2, 8, -1, 60000, 0, 10, 1, -1, 60000, 1, 3600000);
        cal.set(2037, 10, 1, 3, 30, 0);
        harness.check(((TimeZone)tz2).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2037, 10, 1, 3, 31, 0);
        harness.check(!((TimeZone)tz2).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2038, 0, 1, 3, 29, 0);
        harness.check(!((TimeZone)tz2).inDaylightTime(new Date(cal.getTimeInMillis())));
        harness.checkPoint("test 3");
        SimpleTimeZone tz3 = new SimpleTimeZone(-12600000, "Test2", 2, 8, -1, 60000, 10, 1, -1, 3660000, 3600000);
        cal.set(2037, 10, 1, 3, 30, 0);
        harness.check(((TimeZone)tz3).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2037, 10, 1, 3, 31, 0);
        harness.check(!((TimeZone)tz3).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2038, 0, 1, 3, 29, 0);
        harness.check(!((TimeZone)tz3).inDaylightTime(new Date(cal.getTimeInMillis())));
        harness.checkPoint("test 4");
        tz2.setEndRule(10, 1, -1, 3660000);
        cal.set(2037, 10, 1, 3, 30, 0);
        harness.check(((TimeZone)tz2).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2037, 10, 1, 3, 31, 0);
        harness.check(!((TimeZone)tz2).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2038, 0, 1, 3, 29, 0);
        harness.check(!((TimeZone)tz2).inDaylightTime(new Date(cal.getTimeInMillis())));
        harness.checkPoint("test 5");
        SimpleTimeZone tz4 = new SimpleTimeZone(-12600000, "Test1", 2, 8, -1, 60000, 1, 10, 1, -1, 60000, 1, 3600000);
        cal.set(2037, 10, 1, 3, 30, 0);
        harness.check(((TimeZone)tz4).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2037, 10, 1, 3, 31, 0);
        harness.check(!((TimeZone)tz4).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2038, 0, 1, 3, 29, 0);
        harness.check(!((TimeZone)tz4).inDaylightTime(new Date(cal.getTimeInMillis())));
        harness.checkPoint("test 6");
        SimpleTimeZone tz5 = new SimpleTimeZone(-12600000, "Test3", 2, 8, -1, 60000, 0, 1, 0, 60000, 3600000);
        cal.set(2007, 11, 31, 23, 59, 0);
        harness.check(((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 0, 1, 2, 29, 0);
        harness.check(((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 0, 1, 2, 30, 0);
        harness.check(((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 0, 1, 2, 31, 0);
        harness.check(!((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 0, 3, 2, 31, 0);
        harness.check(!((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 0, 3, 2, 31, 0);
        harness.check(!((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 2, 11, 3, 30, 0);
        harness.check(!((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 2, 11, 3, 31, 0);
        harness.check(((TimeZone)tz5).inDaylightTime(new Date(cal.getTimeInMillis())));
        harness.checkPoint("test 7");
        SimpleTimeZone tz6 = new SimpleTimeZone(12600000, "Test4", 2, 6, 0, 5400000, 2, 10, -16, -5, 1800000, 2, 3600000);
        cal.set(2007, 2, 6, 1, 29, 0);
        harness.check(!((TimeZone)tz6).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 2, 6, 1, 30, 0);
        harness.check(((TimeZone)tz6).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 10, 15, 0, 29, 0);
        harness.check(((TimeZone)tz6).inDaylightTime(new Date(cal.getTimeInMillis())));
        cal.set(2007, 10, 15, 0, 30, 0);
        harness.check(!((TimeZone)tz6).inDaylightTime(new Date(cal.getTimeInMillis())));
    }
}

