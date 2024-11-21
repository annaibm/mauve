/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;

public class weekOfYear
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GregorianCalendar d = new GregorianCalendar();
        GregorianCalendar e = new GregorianCalendar();
        int[][] testYears = new int[][]{{2007, 1996, 2}, {2002, 2008, 3}, {2003, 1992, 4}, {1998, 2004, 5}, {1999, 1988, 6}, {2005, 2000, 7}, {2006, 1956, 1}};
        int[] testMonths = new int[]{0, 6};
        int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int minimalDaysInFirstWeek = 1; minimalDaysInFirstWeek <= 7; ++minimalDaysInFirstWeek) {
            d.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
            e.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
            for (int firstDayOfWeek = 1; firstDayOfWeek <= 7; ++firstDayOfWeek) {
                d.setFirstDayOfWeek(firstDayOfWeek);
                e.setFirstDayOfWeek(firstDayOfWeek);
                for (int i = 0; i < testYears.length; ++i) {
                    int dayOfFirst = testYears[i][2];
                    for (int leap = 0; leap <= 1; ++leap) {
                        int year = testYears[i][leap];
                        for (int j = 0; j < testMonths.length; ++j) {
                            int month = testMonths[j];
                            for (int day = 1; day <= 31; ++day) {
                                GregorianCalendar c = new GregorianCalendar(year, month, day);
                                c.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
                                c.setFirstDayOfWeek(firstDayOfWeek);
                                int dayOfYear = 0;
                                for (int k = 0; k < month; ++k) {
                                    dayOfYear += monthLengths[k];
                                }
                                if (month > 1) {
                                    dayOfYear += leap;
                                }
                                harness.check(c.get(6) == (dayOfYear += day));
                                int dayOfWeek = (dayOfFirst + dayOfYear - 2) % 7 + 1;
                                harness.check(c.get(7) == dayOfWeek);
                                int relativeDayOfFirst = (7 + dayOfFirst - firstDayOfWeek) % 7;
                                int dayOfYearOfWeek1Day1 = 1 - relativeDayOfFirst;
                                if (7 - relativeDayOfFirst < minimalDaysInFirstWeek) {
                                    dayOfYearOfWeek1Day1 += 7;
                                }
                                int checkYear = year;
                                if (dayOfYear < dayOfYearOfWeek1Day1) {
                                    if (--checkYear % 4 == 0) {
                                        relativeDayOfFirst = (relativeDayOfFirst + 5) % 7;
                                        dayOfYear += 366;
                                    } else {
                                        relativeDayOfFirst = (relativeDayOfFirst + 6) % 7;
                                        dayOfYear += 365;
                                    }
                                    dayOfYearOfWeek1Day1 = 1 - relativeDayOfFirst;
                                    if (7 - relativeDayOfFirst < minimalDaysInFirstWeek) {
                                        dayOfYearOfWeek1Day1 += 7;
                                    }
                                }
                                int weekOfYear2 = (dayOfYear - dayOfYearOfWeek1Day1 + 7) / 7;
                                harness.check(c.get(3) == weekOfYear2);
                                d.clear();
                                d.set(1, checkYear);
                                d.set(7, dayOfWeek);
                                d.set(3, weekOfYear2);
                                harness.check(d.get(1) == year);
                                harness.check(d.get(2) == month);
                                harness.check(d.get(5) == day);
                            }
                        }
                    }
                }
            }
        }
    }
}

