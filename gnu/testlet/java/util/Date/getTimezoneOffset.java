/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;
import java.util.TimeZone;

public class getTimezoneOffset
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        TimeZone.setDefault(TimeZone.getTimeZone("America/Toronto"));
        this.check(300, 240);
        TimeZone.setDefault(TimeZone.getTimeZone("Pacific/Auckland"));
        this.check(-780, -720);
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        this.check(0, -60);
    }

    private void check(int offset_january, int offset_august) {
        this.harness.checkPoint("getTimezoneOffset for zone: " + TimeZone.getDefault().getID());
        Date d = new Date(96, 1, 14);
        System.out.println(d.getTimezoneOffset());
        this.harness.check(d.getTimezoneOffset(), offset_january);
        d = new Date(96, 8, 1);
        System.out.println(d.getTimezoneOffset());
        this.harness.check(d.getTimezoneOffset(), offset_august);
    }
}

