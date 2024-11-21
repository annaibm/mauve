/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Locale;

public class setFirstDayOfWeek
implements Testlet {
    private int[] mondayDays = new int[]{27, 27, 27, 27, 27, 27, 6, 6, 6, 6, 6, 6, 6, 13, 13, 13, 13, 13, 13, 13, 20, 20, 20, 20, 20, 20, 20, 27, 27, 27, 27, 27};
    private int[] mondayMonths = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

    @Override
    public void test(TestHarness harness) {
        Locale.setDefault(Locale.GERMANY);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        for (int day = 1; day <= 31; ++day) {
            calendar.set(2006, 2, day);
            calendar.get(3);
            harness.check(calendar.get(5), day);
            harness.check(calendar.get(2), 2);
            calendar.set(7, 2);
            harness.check(calendar.get(5), this.mondayDays[day]);
            harness.check(calendar.get(2), this.mondayMonths[day]);
        }
    }
}

