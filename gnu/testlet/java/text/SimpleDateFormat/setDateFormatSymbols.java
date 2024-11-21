/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class setDateFormatSymbols
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.UK);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date jan1_2005 = new Date(1104537600000L);
        harness.check(sdf.format(jan1_2005), (Object)"Sat");
        DateFormatSymbols s = sdf.getDateFormatSymbols();
        s.setShortWeekdays(new String[]{"-", "S", "M", "T", "W", "T", "F", "S"});
        sdf.setDateFormatSymbols(s);
        harness.check(sdf.format(jan1_2005), (Object)"S");
        try {
            sdf.setDateFormatSymbols(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

