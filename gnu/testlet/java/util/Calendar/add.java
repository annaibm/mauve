/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        SimpleDateFormat cdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss zzz", Locale.US);
        cdf.setTimeZone(tz);
        Calendar k = Calendar.getInstance(tz, Locale.US);
        Date epoch = new Date(0L);
        k.setTime(epoch);
        harness.check(cdf.format(epoch), (Object)"Thu, 1 Jan 1970 00:00:00 GMT");
        harness.check(k.getTime(), epoch);
        k.add(1, 0);
        harness.check(k.getTime(), epoch, "no-op add()");
        k.add(1, 12);
        harness.check(k.get(1), 1982, "add() to year");
        k.add(1, -1);
        harness.check(k.get(1), 1981);
        harness.check(k.get(2), 0);
        harness.check(k.get(11), 0);
        k.add(11, 30);
        harness.check(k.get(11), 6, "add() to hour");
        harness.check(k.get(5), 2);
        k.add(11, -20);
        harness.check(k.get(11), 10);
        harness.check(k.get(5), 1);
        k.add(2, -13);
        harness.check(k.get(2), 11, "add() to month");
        harness.check(k.get(1), 1979);
        k.add(2, 2);
        harness.check(k.get(2), 1);
        harness.check(k.get(1), 1980);
        harness.check(k.get(5), 1);
        k.add(5, 28);
        harness.check(k.get(2), 1, "leap year");
        harness.check(k.get(5), 29);
        k.add(5, 1);
        harness.check(k.get(2), 2);
        harness.check(k.get(5), 1);
        harness.check(cdf.format(k.getTime()), "Sat, 1 Mar 1980 10:00:00 GMT", "wrap up");
        this.testPreviousDate(harness);
    }

    public void testPreviousDate(TestHarness harness) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.clear(11);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        Date todayStart = calendar.getTime();
        calendar.setTime(now);
        calendar.add(5, -1);
        calendar.clear(11);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        Date yesterdayStart = calendar.getTime();
        harness.check(yesterdayStart.before(todayStart), "PR27362: Check that clear didn't swallow a previous add() call");
    }
}

