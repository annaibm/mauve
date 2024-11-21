/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.TimeZone;

public class dstOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TimeZone t = TimeZone.getTimeZone("America/Toronto");
        Calendar c = Calendar.getInstance(t);
        harness.check(c.isSet(16));
        c.set(2004, 10, 1);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 0);
        c.set(16, -10000);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == -10000);
        c.set(2004, 9, 1);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 3600000);
        c.set(16, -10000);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == -10000);
        c.clear();
        harness.check(!c.isSet(16));
        harness.check(c.get(16) == 0);
        c.setTimeInMillis(1175595146188L);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 3600000);
        c.clear(16);
        harness.check(!c.isSet(16));
        harness.check(c.get(16) == 3600000);
        c.set(16, 1800000);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 1800000);
        c.setTimeInMillis(1175595146188L);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 3600000);
        c.setTimeInMillis(1172916746188L);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 0);
        c.clear(16);
        harness.check(!c.isSet(16));
        harness.check(c.get(16) == 0);
        c.set(16, 1800000);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 1800000);
        c.setTimeInMillis(1172916746188L);
        harness.check(c.isSet(16));
        harness.check(c.get(16) == 0);
    }
}

