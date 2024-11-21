/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;

public class check14
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int rawOff = -18000000;
        int dstOff = 3600000;
        SimpleTimeZone tzwall = new SimpleTimeZone(rawOff, "Z1", 4, 10, 0, 43200000, 0, 9, 10, 0, 43200000, 0, dstOff);
        SimpleTimeZone tzstd = new SimpleTimeZone(rawOff, "Z2", 4, 10, 0, 43200000, 1, 9, 10, 0, 39600000, 1, dstOff);
        SimpleTimeZone tzutc = new SimpleTimeZone(rawOff, "Z3", 4, 10, 0, 61200000, 2, 9, 10, 0, 57600000, 2, dstOff);
        int wall = tzwall.getOffset(1, 2000, 4, 10, 4, 41400000);
        int std = tzstd.getOffset(1, 2000, 4, 10, 4, 41400000);
        int utc = tzutc.getOffset(1, 2000, 4, 10, 4, 41400000);
        harness.check(wall, rawOff);
        harness.check(std, rawOff);
        harness.check(utc, rawOff);
        wall = tzwall.getOffset(1, 2000, 4, 10, 4, 45000000);
        std = tzstd.getOffset(1, 2000, 4, 10, 4, 45000000);
        utc = tzutc.getOffset(1, 2000, 4, 10, 4, 45000000);
        harness.check(wall, rawOff + dstOff);
        harness.check(std, rawOff + dstOff);
        harness.check(utc, rawOff + dstOff);
        wall = tzwall.getOffset(1, 2000, 9, 10, 3, 41400000 - dstOff);
        std = tzstd.getOffset(1, 2000, 9, 10, 3, 41400000 - dstOff);
        utc = tzutc.getOffset(1, 2000, 9, 10, 3, 41400000 - dstOff);
        harness.check(wall, rawOff + dstOff);
        harness.check(std, rawOff + dstOff);
        harness.check(utc, rawOff + dstOff);
        wall = tzwall.getOffset(1, 2000, 9, 10, 3, 45000000 - dstOff);
        std = tzstd.getOffset(1, 2000, 9, 10, 3, 45000000 - dstOff);
        utc = tzutc.getOffset(1, 2000, 9, 10, 3, 45000000 - dstOff);
        harness.check(wall, rawOff);
        harness.check(std, rawOff);
        harness.check(utc, rawOff);
    }
}

