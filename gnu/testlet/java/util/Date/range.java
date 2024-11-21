/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;

public class range
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.check(70, 0, 1, 0, 0, 0, 0L);
        this.check(104, 9, 12, 0, 0, 0, 1097539200000L);
        this.check(104, 9, 12, 0, 0, 0, 1097539200000L);
        this.check(104, 9, 12, 12, 34, 0, 1097584440000L);
        this.check(104, 9, 12, 12, 34, 56, 1097584496000L);
        this.check(104, -1, 0, 0, 0, 0, 1070150400000L);
        this.check(104, 99, 99, 99, 99, 99, 1342068039000L);
        this.check(104, 999, 999, 999, 999, 999, 3789878139000L);
        this.check(104, -1, -1, -1, -1, -1, 1070060339000L);
        this.check(104, -999, -999, -999, -999, -999, -1644306939000L);
    }

    private void check(int year, int month, int day, int hours, int mins, int secs, long l) {
        try {
            Date d = new Date(year, month, day, hours, mins, secs);
            this.harness.check(d.getTime() - (long)(d.getTimezoneOffset() * 60 * 1000) == l);
        }
        catch (Throwable t) {
            this.harness.debug(t);
            this.harness.check(false);
        }
    }
}

