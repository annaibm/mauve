/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy");
        harness.check(((DateFormat)f1).equals(f2));
        harness.check(((DateFormat)f2).equals(f1));
        GregorianCalendar c1 = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.UK);
        GregorianCalendar c2 = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.UK);
        long millis = System.currentTimeMillis();
        c1.setTimeInMillis(millis);
        c2.setTimeInMillis(millis);
        f1.setCalendar(c1);
        f2.setCalendar(c2);
        harness.check(((DateFormat)f1).equals(f2));
        c1.setTimeInMillis(123L);
        harness.check(((DateFormat)f1).equals(f2));
        c2.setTimeInMillis(123L);
        harness.check(((DateFormat)f1).equals(f2));
        c1.setFirstDayOfWeek(5);
        harness.check(!((DateFormat)f1).equals(f2));
        c2.setFirstDayOfWeek(5);
        harness.check(((DateFormat)f1).equals(f2));
        c1.setMinimalDaysInFirstWeek(6);
        harness.check(!((DateFormat)f1).equals(f2));
        c2.setMinimalDaysInFirstWeek(6);
        harness.check(((DateFormat)f1).equals(f2));
        c1.setTimeZone(new SimpleTimeZone(0, "Z1"));
        harness.check(!((DateFormat)f1).equals(f2));
        c2.setTimeZone(new SimpleTimeZone(0, "Z1"));
        harness.check(((DateFormat)f1).equals(f2));
        c1 = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.UK);
        c2 = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        c1.setTimeInMillis(millis);
        c2.setTimeInMillis(millis);
        f1.setCalendar(c1);
        f2.setCalendar(c2);
        harness.check(!((DateFormat)f1).equals(f2));
        c2 = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.UK);
        c2.setTimeInMillis(millis);
        f2.setCalendar(c2);
        harness.check(((DateFormat)f1).equals(f2));
        c1.setGregorianChange(new Date(123L));
        harness.check(((DateFormat)f1).equals(f2));
        c2.setGregorianChange(new Date(123L));
        harness.check(((DateFormat)f1).equals(f2));
    }
}

