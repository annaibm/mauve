/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.util.Locale;

public class formatExp
implements Testlet {
    public void apply(TestHarness harness, DecimalFormat df, String pattern) {
        harness.checkPoint("pattern " + pattern);
        boolean ok = true;
        try {
            df.applyPattern(pattern);
        }
        catch (IllegalArgumentException x) {
            ok = false;
        }
        harness.check(ok);
    }

    @Override
    public void test(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        DecimalFormat df = new DecimalFormat();
        this.apply(harness, df, "0.0000E0");
        harness.check(df.format(200000L), (Object)"2.0000E5");
        this.apply(harness, df, "00.00E00");
        harness.check(df.format(200000L), (Object)"20.00E04");
        this.apply(harness, df, "##0.####E0");
        harness.check(df.format(12345L), (Object)"12.345E3");
        this.apply(harness, df, "##.###E0");
        harness.check(df.format(12345L), (Object)"1.2345E4");
        this.apply(harness, df, "##.###E0");
        harness.check(df.format(12346L), (Object)"1.2346E4");
        this.apply(harness, df, "00.###E0");
        harness.check(df.format(12345L), (Object)"12.345E3");
        harness.check(df.format(1234L), (Object)"12.34E2");
        harness.check(df.format(0.00123), (Object)"12.3E-4");
        this.apply(harness, df, "0E0");
        harness.check(df.format(-1234.567), (Object)"-1E3");
        this.apply(harness, df, "00E00");
        harness.check(df.format(-1234.567), (Object)"-12E02");
        this.apply(harness, df, "000E00");
        harness.check(df.format(-1234.567), (Object)"-123E01");
        this.apply(harness, df, "0000000000E0");
        harness.check(df.format(-1234.567), (Object)"-1234567000E-6");
        this.apply(harness, df, "0.0E0");
        harness.check(df.format(-1234.567), (Object)"-1.2E3");
        this.apply(harness, df, "00.00E0");
        harness.check(df.format(-1234.567), (Object)"-12.35E2");
        harness.check(df.format(-0.1234567), (Object)"-12.35E-2");
    }
}

