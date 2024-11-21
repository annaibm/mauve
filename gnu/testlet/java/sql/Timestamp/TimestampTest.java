/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Timestamp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.sql.Timestamp;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TimestampTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleTimeZone stz = new SimpleTimeZone(-18000000, "GMT");
        TimeZone.setDefault(stz);
        try {
            Timestamp.valueOf("NoSuchTime");
            harness.check(false, "valueOf");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "valueOf");
        }
        Timestamp ts = new Timestamp(1099999999333L);
        harness.check(ts.getNanos() == 333000000, "getNanos");
        harness.check(ts.toString().equals("2004-11-09 06:33:19.333"), "toString");
        harness.debug(ts.toString());
        ts.setNanos(42);
        harness.check(ts.getNanos() == 42, "getNanos");
        harness.check(ts.toString().equals("2004-11-09 06:33:19.000000042"), "toString");
        harness.debug(ts.toString());
        ts.setNanos(0);
        harness.check(ts.getNanos() == 0, "getNanos");
        harness.check(ts.toString().equals("2004-11-09 06:33:19.0"), "toString");
        harness.debug(ts.toString());
        Timestamp ts2 = new Timestamp(1099999999999L);
        harness.check(!ts.equals(ts2), "equals");
        ts.setNanos(999000000);
        harness.check(ts.equals(ts2), "equals");
        harness.debug(ts.toString());
        TimeZone.setDefault(null);
    }
}

