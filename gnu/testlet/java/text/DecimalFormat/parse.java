/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class parse
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

    public Number parseIt(DecimalFormat df, String string, ParsePosition pos) {
        pos.setIndex(0);
        return df.parse(string, pos);
    }

    @Override
    public void test(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        ParsePosition pp = new ParsePosition(0);
        DecimalFormat df = new DecimalFormat("0.##;-0.##");
        Number num = this.parseIt(df, "-1234.56", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), -1234.56);
        num = this.parseIt(df, "-0", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), -0.0);
        num = this.parseIt(df, "-0.0", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), -0.0);
        this.apply(harness, df, "0.#");
        num = this.parseIt(df, "1234.6", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), 1234.6);
        this.apply(harness, df, "0");
        num = this.parseIt(df, "-1235", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), -1235L);
        num = this.parseIt(df, Long.toString(Long.MIN_VALUE), pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), Long.MIN_VALUE);
        this.apply(harness, df, "'#'#.#");
        num = this.parseIt(df, "#30", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 30L);
        num = this.parseIt(df, "xx30", pp);
        harness.check(num, null);
        this.apply(harness, df, "0.0000E0");
        num = this.parseIt(df, "2.000E5", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 200000L);
        num = this.parseIt(df, "2.0000E-5", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), 2.0E-5);
        num = this.parseIt(df, "2.000-E5", pp);
        harness.check(num instanceof Long);
        harness.check(num.doubleValue(), 2.0);
        this.apply(harness, df, "0.000");
        num = this.parseIt(df, "2.000", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 2L);
        this.apply(harness, df, "###0.#;(###0.#)");
        num = this.parseIt(df, "201.2", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), 201.2);
        num = this.parseIt(df, "(201.2)", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), -201.2);
        this.apply(harness, df, "0.#;0.#-");
        num = this.parseIt(df, "303", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 303L);
        num = this.parseIt(df, "303-", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), -303L);
        num = this.parseIt(df, "1.", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 1L);
        num = this.parseIt(df, "1.0", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 1L);
        num = this.parseIt(df, ".01", pp);
        harness.check(num instanceof Double);
        harness.check(num.longValue(), 0L);
        num = this.parseIt(df, "9223372036854775808-", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), Long.MIN_VALUE);
        this.apply(harness, df, "0.###;0.###-");
        num = this.parseIt(df, ".01", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), 0.01);
        num = this.parseIt(df, ".05", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), 0.05);
        num = this.parseIt(df, ".5", pp);
        harness.check(num instanceof Double);
        harness.check(num.doubleValue(), 0.5);
        this.apply(harness, df, "#,##0.00");
        num = this.parseIt(df, "3,110.00", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 3110L);
        this.apply(harness, df, "#,##0.00");
        num = this.parseIt(df, "31,10.00", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 3110L);
        this.apply(harness, df, "#,##0.00");
        num = this.parseIt(df, "3110", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 3110L);
        this.apply(harness, df, "#,##0X");
        num = this.parseIt(df, "3,110X", pp);
        harness.check(num instanceof Long);
        harness.check(num.longValue(), 3110L);
        this.apply(harness, df, "#,##0X");
        num = this.parseIt(df, "3,110", pp);
        harness.check(num == null);
        harness.check(pp.getErrorIndex() == 5);
        this.apply(harness, df, "#,##0X");
        num = this.parseIt(df, "3,110Y", pp);
        harness.check(num == null);
        harness.check(pp.getErrorIndex(), 5);
    }
}

