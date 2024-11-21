/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class getMinimalDaysInFirstWeek
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test10546(harness);
    }

    private void test10546(TestHarness harness) {
        GregorianCalendar c1 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"), Locale.UK);
        c1.clear();
        c1.set(1, 2005);
        c1.set(3, 1);
        c1.set(7, c1.getFirstDayOfWeek());
        harness.check(c1.getMinimalDaysInFirstWeek(), 4);
        GregorianCalendar c2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris"), Locale.FRANCE);
        c2.clear();
        c2.set(1, 2005);
        c2.set(3, 1);
        c2.set(7, c2.getFirstDayOfWeek());
        harness.check(c2.getMinimalDaysInFirstWeek(), 4);
    }
}

