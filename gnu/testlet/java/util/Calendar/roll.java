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

public class roll
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
        k.roll(1, 0);
        harness.check(k.getTime(), epoch, "no-op add()");
        k.roll(1, 10);
        harness.check(k.get(1), 1980, "roll() year");
        harness.check(cdf.format(k.getTime()), (Object)"Tue, 1 Jan 1980 00:00:00 GMT");
        k.roll(2, -3);
        harness.check(k.get(2), 9, "roll() month");
        harness.check(k.get(1), 1980);
    }
}

