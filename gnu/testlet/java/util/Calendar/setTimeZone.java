/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class setTimeZone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        cal.setTime(new Date());
        int hour1 = cal.get(11);
        cal.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        int hour2 = cal.get(11);
        int delta = (hour1 - hour2 + 24) % 24;
        harness.check(delta, 5);
    }
}

