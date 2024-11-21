/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class set
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSimple(harness);
        this.test_DST(harness);
        this.test_DAY_OF_MONTH(harness);
        this.testUnsetFields(harness);
        this.testLenience(harness);
        this.testConflictingFields(harness);
        this.testNormalization(harness);
        this.testModSeconds(harness);
    }

    private void testSimple(TestHarness harness) {
        harness.checkPoint("Simple tests");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        c.setTimeZone(TimeZone.getTimeZone("GMT"));
        c.clear();
        c.set(1, 1980);
        c.set(2, 6);
        c.set(5, 18);
        c.set(11, 22);
        c.set(12, 13);
        c.set(13, 13);
        c.set(14, 347);
        harness.check(c.getTime(), new Date(332806393347L));
        c.clear();
        c.set(1, 1980);
        c.set(2, 6);
        c.set(8, -3);
        c.set(7, 1);
        c.set(11, 18);
        c.set(12, 19);
        c.set(13, 12);
        c.set(14, 519);
        harness.check(c.getTime(), new Date(332360352519L));
    }

    public void test_DST(TestHarness harness) {
        SimpleTimeZone stz = new SimpleTimeZone(3600000, "MyZone", 2, -1, 1, 0x6DDD00, 9, -1, 1, 0x6DDD00);
        TimeZone.setDefault(stz);
        Calendar cal = Calendar.getInstance(stz);
        Calendar cal2 = Calendar.getInstance(stz);
        cal.set(2004, 10, 4, 17, 30);
        harness.checkPoint("Basic set/get");
        harness.check(cal.get(12), 30);
        harness.check(cal.get(10), 5);
        harness.check(cal.get(2), 10);
        harness.check(cal.get(7), 5);
        harness.check(cal.get(9), 1);
        harness.check(cal.get(15), 3600000);
        harness.check(cal.get(16), 0);
        harness.check(cal.get(4), 1);
        cal.set(2, 3);
        harness.check(cal.get(2), 3);
        harness.check(cal.get(11), 17);
        harness.checkPoint("moving calendar across DST boundary");
        harness.check(cal.getTime().getHours(), 17);
        cal2.setTimeInMillis(cal.getTimeInMillis());
        harness.check(cal2.get(11), 17);
        TimeZone.setDefault(null);
    }

    public void test_DAY_OF_MONTH(TestHarness harness) {
        harness.checkPoint("setting DAY_OF_MONTH etc shouldn't effect other fields");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEEEEEE, yyyy-MM-dd [DDD] HH:mm:ss.SSSS", Locale.US);
        c.set(2004, 9, 1, 12, 0, 0);
        c.set(14, 0);
        String time2 = df.format(c.getTime());
        harness.check(time2, (Object)"Friday, 2004-10-01 [275] 12:00:00.0000");
        c.set(5, 31);
        time2 = df.format(c.getTime());
        harness.check(time2, (Object)"Sunday, 2004-10-31 [305] 12:00:00.0000");
        c.set(2, 0);
        time2 = df.format(c.getTime());
        harness.check(time2, (Object)"Saturday, 2004-01-31 [031] 12:00:00.0000");
    }

    private void testUnsetFields(TestHarness harness) {
        harness.checkPoint("setting only some fields");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        c.setTimeZone(TimeZone.getTimeZone("GMT"));
        c.clear();
        harness.check(c.getTime(), new Date(0L));
        c.clear();
        c.set(1, 1982);
        harness.check(c.getTime(), new Date(378691200000L));
        c.clear();
        c.set(7, 1);
        harness.check(c.getTime(), new Date(259200000L));
        c.clear();
        c.set(8, 3);
        harness.check(c.getTime(), new Date(1555200000L));
        c.clear();
        c.set(3, 2);
        harness.check(c.getTime(), new Date(345600000L));
        c.clear();
        c.set(1, 1978);
        c.set(2, 7);
        harness.check(c.getTime(), new Date(270777600000L));
        c.clear();
        c.set(1, 2004);
        c.set(2, 10);
        c.set(7, 7);
        harness.check(c.getTime(), new Date(1099699200000L));
    }

    private void testLenience(TestHarness harness) {
        harness.checkPoint("test the setLenient() functionality");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        c.setLenient(false);
        c.set(2, 42);
        boolean b = false;
        try {
            c.get(2);
        }
        catch (IllegalArgumentException e) {
            b = true;
        }
        harness.check(b);
    }

    private void testConflictingFields(TestHarness harness) {
        harness.checkPoint("test setting conflicting values of different fields");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        c.setTimeZone(TimeZone.getTimeZone("GMT"));
        c.clear();
        c.set(1, 1997);
        c.set(6, 55);
        c.set(5, 18);
        c.set(2, 4);
        harness.check(c.getTime(), new Date(863913600000L));
        c.clear();
        c.set(11, 8);
        c.set(1, 1997);
        c.set(11, 8);
        c.set(5, 18);
        c.set(2, 4);
        c.set(6, 55);
        harness.check(c.getTime(), new Date(856771200000L));
        c.clear();
        c.set(11, 8);
        c.set(1, 1997);
        c.set(11, 8);
        c.set(5, 18);
        c.set(2, 4);
        c.set(6, 55);
        c.set(2, 7);
        c.set(8, 3);
        c.set(7, 3);
        harness.check(c.getTime(), new Date(871977600000L));
        c.clear();
        c.set(6, 55);
        c.set(2, 7);
        harness.check(c.get(2), 1);
        c.clear();
        c.set(11, 14);
        c.set(10, 8);
        harness.check(c.get(10), 2);
    }

    private void testNormalization(TestHarness harness) {
        harness.checkPoint("Normalization");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        c.setTimeZone(TimeZone.getTimeZone("GMT"));
        c.clear();
        c.set(1, 1980);
        c.set(2, 6);
        c.set(5, 18);
        c.set(11, -22);
        c.set(12, 13);
        c.set(13, 13);
        harness.check(c.getTime(), new Date(332647993000L));
        c.clear();
        c.set(1, 1980);
        c.set(2, 6);
        c.set(5, 18);
        c.set(10, 12);
        c.set(9, 0);
        c.set(12, 13);
        c.set(13, 13);
        harness.check(c.get(10), 0);
        harness.check(c.get(9), 1);
        c.clear();
        c.set(1, 1997);
        c.set(2, 2);
        c.set(5, 1);
        c.set(11, -8784);
        harness.check(c.getTime(), new Date(825552000000L));
    }

    private void testModSeconds(TestHarness harness) {
        harness.checkPoint("ModSeconds");
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        c.setTimeZone(TimeZone.getTimeZone("GMT"));
        c.setLenient(true);
        c.set(1, 2005);
        c.set(2, 10);
        c.set(5, 2);
        c.set(10, 2);
        c.set(9, 0);
        c.set(12, 30);
        long t = c.getTimeInMillis() + 5500L;
        c.setTimeInMillis(t);
        c.set(13, 0);
        c.set(14, 0);
        c.getTime();
        harness.check(c.get(1), 2005);
        harness.check(c.get(13), 0);
    }
}

