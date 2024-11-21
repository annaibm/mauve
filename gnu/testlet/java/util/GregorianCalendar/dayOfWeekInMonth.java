/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;

public class dayOfWeekInMonth
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GregorianCalendar c = new GregorianCalendar();
        GregorianCalendar d = new GregorianCalendar();
        GregorianCalendar e = new GregorianCalendar();
        int[][] testMonths = new int[][]{{0, 2007, 2}, {4, 2007, 3}, {7, 2007, 4}, {2, 2007, 5}, {11, 2006, 6}, {11, 2007, 7}, {6, 2007, 1}};
        for (int minimalDaysInFirstWeek = 1; minimalDaysInFirstWeek <= 7; ++minimalDaysInFirstWeek) {
            c.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
            d.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
            e.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
            for (int firstDayOfWeek = 1; firstDayOfWeek <= 7; ++firstDayOfWeek) {
                c.setFirstDayOfWeek(firstDayOfWeek);
                d.setFirstDayOfWeek(firstDayOfWeek);
                e.setFirstDayOfWeek(firstDayOfWeek);
                for (int i = 0; i < testMonths.length; ++i) {
                    int month = testMonths[i][0];
                    int year = testMonths[i][1];
                    int first2 = testMonths[i][2];
                    for (int day = 1; day <= 31; ++day) {
                        int relativeDayOfWeek;
                        int relativeDayOfFirst;
                        c.set(year, month, day);
                        int dayOfWeekInMonth2 = (day + 6) / 7;
                        harness.check(c.get(8) == dayOfWeekInMonth2);
                        int dayOfWeek = c.get(7);
                        if (day == 1) {
                            harness.check(dayOfWeek == first2);
                        }
                        int weekOfFirst = 7 - (relativeDayOfFirst = ((relativeDayOfWeek = (7 + dayOfWeek - firstDayOfWeek) % 7) - day + 1 + 35) % 7) >= minimalDaysInFirstWeek ? 1 : 0;
                        int weekOfMonth = (day + relativeDayOfFirst - 1) / 7 + weekOfFirst;
                        harness.check(c.get(4) == weekOfMonth);
                        d.clear();
                        d.set(1, year);
                        d.set(2, month);
                        d.set(8, dayOfWeekInMonth2);
                        d.set(7, dayOfWeek);
                        harness.check(d.get(5) == day);
                        e.clear();
                        e.set(1, year);
                        e.set(2, month);
                        e.set(4, weekOfMonth);
                        e.set(7, dayOfWeek);
                        harness.check(e.get(5) == day);
                    }
                }
            }
        }
    }
}

