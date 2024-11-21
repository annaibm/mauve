/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Test
extends DateFormat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0, 0, "ERA_FIELD");
        harness.check(1, 1, "YEAR_FIELD");
        harness.check(2, 2, "MONTH_FIELD");
        harness.check(3, 3, "DATE_FIELD");
        harness.check(4, 4, "HOUR_OF_DAY1_FIELD");
        harness.check(5, 5, "HOUR_OF_DAY0_FIELD");
        harness.check(6, 6, "MINUTE_FIELD");
        harness.check(7, 7, "SECOND_FIELD");
        harness.check(8, 8, "MILLISECOND_FIELD");
        harness.check(9, 9, "DAY_OF_WEEK_FIELD");
        harness.check(10, 10, "DAY_OF_YEAR_FIELD");
        harness.check(11, 11, "DAY_OF_WEEK_IN_MONTH_FIELD");
        harness.check(12, 12, "WEEK_OF_YEAR_FIELD");
        harness.check(13, 13, "WEEK_OF_MONTH_FIELD");
        harness.check(14, 14, "AM_PM_FIELD");
        harness.check(15, 15, "HOUR1_FIELD");
        harness.check(16, 16, "HOUR0_FIELD");
        harness.check(17, 17, "TIMEZONE_FIELD");
        harness.check(0, 0, "FULL");
        harness.check(1, 1, "LONG");
        harness.check(2, 2, "MEDIUM");
        harness.check(3, 3, "SHORT");
        harness.check(2, 2, "DEFAULT");
        GregorianCalendar c = new GregorianCalendar();
        this.setCalendar(c);
        harness.check(this.getCalendar(), c, "get/setCalendar");
        harness.check(this.calendar, c, "calendar");
        NumberFormat nf = NumberFormat.getNumberInstance();
        this.setNumberFormat(nf);
        harness.check(this.getNumberFormat(), nf, "get/setNumberFormat");
        harness.check(this.numberFormat, nf, "numberFormat");
        this.setLenient(true);
        harness.check(this.isLenient(), "set/isLenient (true)");
        this.setLenient(false);
        harness.check(!this.isLenient(), "set/isLenient (false)");
        TimeZone tz = TimeZone.getDefault();
        this.setTimeZone(tz);
        harness.check(this.getTimeZone(), tz, "get/setTimeZone");
        Object t = this.clone();
        harness.check(this.equals(t), "clone/equals");
        Test.getInstance();
        Test.getDateInstance(0, Locale.US);
        harness.check(true, "getInstance");
    }

    @Override
    public StringBuffer format(Date date, StringBuffer sb, FieldPosition pos) {
        return null;
    }

    @Override
    public Date parse(String text2, ParsePosition pos) {
        return null;
    }
}

