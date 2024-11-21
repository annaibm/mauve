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

public class getAndSet2DigitYearStart
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String pattern = "EEEE, MMMM d, yyyy h:mm:ss 'o''clock' a";
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, dfs);
        Date d = new Date(System.currentTimeMillis());
        sdf.set2DigitYearStart(d);
        harness.check(sdf.get2DigitYearStart(), d, "set/get2DigitYearStart()");
    }
}

