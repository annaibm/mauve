/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        SimpleTimeZone z1 = new SimpleTimeZone(18000000, "Z1");
        SimpleTimeZone z2 = new SimpleTimeZone(18000000, "Z1");
        harness.check(z1.equals(z2));
        harness.check(z1.hashCode(), z2.hashCode());
    }

    private void test2(TestHarness harness) {
        SimpleTimeZone utc = new SimpleTimeZone(0, "GMT");
        TimeZone.setDefault(utc);
        Calendar cal = Calendar.getInstance(utc);
        SimpleTimeZone tz2 = new SimpleTimeZone(-12600000, "Test1", 2, 8, -1, 60000, 0, 10, 1, -1, 60000, 1, 3600000);
        SimpleTimeZone tz3 = new SimpleTimeZone(-12600000, "Test2", 2, 8, -1, 60000, 10, 1, -1, 3660000, 3600000);
        harness.check(((Object)tz2).hashCode() != ((Object)tz3).hashCode());
        tz2.setEndRule(10, 1, -1, 3660000);
        harness.check(((Object)tz2).hashCode() == ((Object)tz3).hashCode());
    }
}

