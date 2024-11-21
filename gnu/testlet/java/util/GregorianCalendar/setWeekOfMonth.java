/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class setWeekOfMonth
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        cal.set(2006, 6, 30);
        cal.setLenient(false);
        harness.check(cal.getMaximum(4), 6);
        cal.clear(5);
        cal.set(4, 1);
        cal.set(7, 7);
        harness.check(cal.get(5), 1);
        cal.clear(5);
        cal.set(4, 6);
        cal.set(7, 2);
        harness.check(cal.get(5), 31);
        cal.set(1998, 1, 14);
        cal.clear(5);
        cal.set(4, 1);
        cal.set(7, 1);
        harness.check(cal.get(5), 1);
        cal.clear(5);
        cal.set(4, 4);
        cal.set(7, 7);
        harness.check(cal.get(5), 28);
        harness.check(cal.get(2), 1);
        cal.set(1993, 1, 14);
        cal.clear(5);
        cal.set(4, 5);
        cal.set(7, 1);
        harness.check(cal.get(5), 28);
    }
}

