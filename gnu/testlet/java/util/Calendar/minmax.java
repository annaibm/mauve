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

public class minmax
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        SimpleDateFormat cdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss zzz");
        cdf.setTimeZone(tz);
        Calendar k = Calendar.getInstance(tz, Locale.US);
        Date epoch = new Date(0L);
        k.setTime(epoch);
        harness.check(k.getMinimum(2), 0, "min month");
        harness.check(k.getMaximum(2), 11, "max month");
        harness.check(k.getMinimum(5), 1, "min date");
        harness.check(k.getMaximum(5), 31, "max date");
        harness.check(k.getMinimum(6), 1, "min day of year");
        harness.check(k.getMaximum(6), 366, "max day of year");
        k.add(2, 3);
        harness.check(k.getActualMinimum(5), 1, "actual min date");
        harness.check(k.getActualMaximum(5), 30, "actual max date");
        harness.check(k.getActualMinimum(6), 1, "actual min day of year");
        harness.check(k.getActualMaximum(6), 365, "actual max day of year");
    }
}

