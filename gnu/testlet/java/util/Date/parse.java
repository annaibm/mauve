/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;

public class parse
implements Testlet {
    private TestHarness harness;
    static final long TZ_DIFF_MAX = 86400000L;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.testParse("6 Sep 2003", 1062806400000L, 86400000L);
        this.testParse("2003/9/6 9:30 PST", 1062869400000L, 2003, 9, 6);
        this.testParse("6 Sep 2003 9:30 PST", 1062869400000L, 2003, 9, 6);
        this.testParse("6 Sep 2003 9:30 AM PST", 1062869400000L, 2003, 9, 6);
        this.testParse("6 Sep 2003 9:30 pm EDT", 1062898200000L, 2003, 9, 6);
        this.testParse("6 Sep 2003 UTC", 1062806400000L, 2003, 9, 6);
        this.testParse("2/28/08 23:30 gmt", 1204241400000L, 2008, 2, 28);
    }

    private void testParse(String s, long exp, int year, int month, int date) {
        long t = Date.parse(s);
        Date d = new Date(t);
        this.harness.checkPoint(s);
        this.harness.check(t, exp);
        this.harness.checkPoint(s + " .getYear");
        this.harness.check(1900 + d.getYear(), year);
        this.harness.checkPoint(s + " .getMonth");
        this.harness.check(1 + d.getMonth(), month);
        this.harness.checkPoint(s + " .getMonth");
        int dd = d.getDate();
        this.harness.checkPoint(s + " .getDate");
        this.harness.check(dd >= date - 1 && dd <= date + 1);
    }

    private void testParse(String s, long exp, long fuzz) {
        this.harness.checkPoint(s);
        long t = Date.parse(s);
        this.harness.check(t >= exp - fuzz && t <= exp + fuzz);
    }
}

