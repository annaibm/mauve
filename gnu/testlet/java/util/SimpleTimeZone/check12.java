/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class check12
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int rawOff = -18000000;
        int dstOff = 3600000;
        SimpleTimeZone tz = new SimpleTimeZone(rawOff, "Z1", 3, 10, 0, 43200000, 8, 10, 0, 43200000, dstOff);
        int off = tz.getOffset(1, 2004, 3, 10, 7, 41400000);
        harness.check(off, rawOff);
        off = tz.getOffset(1, 2004, 3, 10, 7, 45000000);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 8, 10, 6, 41400000 - dstOff);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 8, 10, 6, 45000000 - dstOff);
        harness.check(off, rawOff);
        tz.setStartRule(3, 2, 7, 43200000);
        off = tz.getOffset(1, 2004, 3, 10, 7, 41400000);
        harness.check(off, rawOff);
        off = tz.getOffset(1, 2004, 3, 10, 7, 45000000);
        harness.check(off, rawOff + dstOff);
        tz.setEndRule(8, 2, 6, 43200000);
        off = tz.getOffset(1, 2004, 8, 10, 6, 41400000 - dstOff);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 8, 10, 6, 45000000 - dstOff);
        harness.check(off, rawOff);
        tz.setStartRule(3, -3, 7, 43200000);
        off = tz.getOffset(1, 2004, 3, 10, 7, 41400000);
        harness.check(off, rawOff);
        off = tz.getOffset(1, 2004, 3, 10, 7, 45000000);
        harness.check(off, rawOff + dstOff);
        tz.setEndRule(8, -3, 6, 43200000);
        off = tz.getOffset(1, 2004, 8, 10, 6, 41400000 - dstOff);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 8, 10, 6, 45000000 - dstOff);
        harness.check(off, rawOff);
        tz.setStartRule(3, 5, 6, 43200000, false);
        off = tz.getOffset(1, 2004, 3, 2, 6, 41400000);
        harness.check(off, rawOff);
        off = tz.getOffset(1, 2004, 3, 2, 6, 45000000);
        harness.check(off, rawOff + dstOff);
        tz.setEndRule(8, -15, -6, 43200000);
        off = tz.getOffset(1, 2004, 8, 10, 6, 41400000 - dstOff);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 8, 10, 6, 45000000 - dstOff);
        harness.check(off, rawOff);
        tz.setStartRule(3, 5, 1, 43200000, true);
        off = tz.getOffset(1, 2004, 3, 11, 1, 41400000);
        harness.check(off, rawOff);
        off = tz.getOffset(1, 2004, 3, 11, 1, 45000000);
        harness.check(off, rawOff + dstOff);
        tz.setEndRule(8, 6, -6, 43200000);
        off = tz.getOffset(1, 2004, 8, 10, 6, 41400000 - dstOff);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 8, 10, 6, 45000000 - dstOff);
        harness.check(off, rawOff);
        tz.setEndRule(8, -6, -3, 43200000);
        off = tz.getOffset(1, 2004, 7, 31, 3, 41400000 - dstOff);
        harness.check(off, rawOff + dstOff);
        off = tz.getOffset(1, 2004, 7, 31, 3, 45000000 - dstOff);
        harness.check(off, rawOff);
        Date date = new Date(1034705556525L);
        TimeZone zone = TimeZone.getTimeZone("EST");
        DateFormat dateFormat = DateFormat.getDateTimeInstance(3, 1, Locale.US);
        dateFormat.setTimeZone(zone);
        harness.check(dateFormat.format(date), (Object)"10/15/02 2:12:36 PM EDT");
    }
}

