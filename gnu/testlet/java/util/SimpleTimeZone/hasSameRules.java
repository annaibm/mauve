/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class hasSameRules
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        SimpleTimeZone z1 = new SimpleTimeZone(18000000, "Z1");
        harness.check(!z1.hasSameRules(null));
        SimpleTimeZone z2 = new SimpleTimeZone(18000000, "Z1");
        harness.check(z1.hasSameRules(z2));
        harness.check(z2.hasSameRules(z1));
        int rawOffset1 = 18000000;
        int rawOffset2 = 21600000;
        int time1 = 0x6DDD00;
        int time2 = 10800000;
        z1 = new SimpleTimeZone(rawOffset1, "Z1", 3, 5, 0, time1, 8, 15, 0, time2, 3600000);
        z2 = new SimpleTimeZone(rawOffset1, "Z2", 3, 5, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 3, 5, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 3, 5, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 5, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 4, 5, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 4, 6, 0, time1, 8, 15, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time2, 8, 15, 0, time2, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 4, 6, 0, time2, 8, 15, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time2, 9, 15, 0, time2, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 4, 6, 0, time2, 9, 15, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time2, 9, 16, 0, time2, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 4, 6, 0, time2, 9, 16, 0, time2, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time2, 9, 16, 0, time1, 3600000);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time2, 9, 16, 0, time1, 3600000);
        harness.check(z1.hasSameRules(z2));
        z1 = new SimpleTimeZone(rawOffset2, "Z1", 4, 6, 0, time2, 9, 16, 0, time1, 3600001);
        harness.check(!z1.hasSameRules(z2));
        z2 = new SimpleTimeZone(rawOffset2, "Z2", 4, 6, 0, time2, 9, 16, 0, time1, 3600001);
        harness.check(z1.hasSameRules(z2));
    }

    private void test2(TestHarness harness) {
        SimpleTimeZone utc = new SimpleTimeZone(0, "GMT");
        TimeZone.setDefault(utc);
        Calendar cal = Calendar.getInstance(utc);
        SimpleTimeZone tz2 = new SimpleTimeZone(-12600000, "Test1", 2, 8, -1, 60000, 0, 10, 1, -1, 60000, 1, 3600000);
        SimpleTimeZone tz3 = new SimpleTimeZone(-12600000, "Test2", 2, 8, -1, 60000, 10, 1, -1, 3660000, 3600000);
        harness.check(!((TimeZone)tz2).hasSameRules(tz3));
        tz2.setEndRule(10, 1, -1, 3660000);
        harness.check(((TimeZone)tz2).hasSameRules(tz3));
    }
}

