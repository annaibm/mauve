/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Date;

public class TimeZone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(java.util.TimeZone.getTimeZone("GMT+0"));
        cal.setTime(new Date());
        int hour1 = cal.get(11);
        cal.setTimeZone(java.util.TimeZone.getTimeZone("GMT-5"));
        int hour2 = cal.get(11);
        int delta = (hour1 - hour2 + 24) % 24;
        harness.check(delta, 5, "Check side effect of timezone setting");
    }
}

