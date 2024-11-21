/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class format
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testRounding(harness);
        this.testMiscellaneous(harness);
        this.testBigInteger(harness);
        this.testNaN(harness);
        this.testInfinity(harness);
        this.testMaximumDigits(harness);
        this.testLocale(harness);
    }

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

    public void testGeneral(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        DecimalFormat df = new DecimalFormat("0.##;-0.##");
        harness.check(df.format(-1234.56), (Object)"-1234.56");
        harness.check(df.format(1234.56), (Object)"1234.56");
        this.apply(harness, df, "0.#");
        harness.check(df.format(-1234.56), (Object)"-1234.6");
        harness.check(df.format(1234.56), (Object)"1234.6");
        this.apply(harness, df, "#,##0.##;-#");
        harness.check(df.format(-1234.56), (Object)"-1,234.56");
        harness.check(df.format(1234.56), (Object)"1,234.56");
        this.apply(harness, df, "#,##0.###");
        harness.check(df.format(80.0), (Object)"80");
        this.apply(harness, df, "00,000.000;-00,000.000");
        harness.check(df.format(-1234.56), (Object)"-01,234.560");
        harness.check(df.format(1234.56), (Object)"01,234.560");
        this.apply(harness, df, "##,###,####.");
        df.setDecimalSeparatorAlwaysShown(true);
        harness.check(df.format(-1234.56), (Object)"-1235.");
        harness.check(df.format(1234.56), (Object)"1235.");
        harness.check(df.format(-1234567.89), (Object)"-123,4568.");
        this.apply(harness, df, "#,###,###");
        harness.check(df.format(-1234567.89), (Object)"-1,234,568");
        this.apply(harness, df, "0");
        harness.check(df.format(-1234.56), (Object)"-1235");
        harness.check(df.format(1234.56), (Object)"1235");
        harness.check(df.format(Long.MIN_VALUE), (Object)"-9223372036854775808");
        this.apply(harness, df, "#");
        harness.check(df.format(0L), (Object)"0");
        harness.check(df.format(0.0), (Object)"0");
        this.apply(harness, df, "###0.#;(###0.#)");
        harness.check(df.format(-1234.56), (Object)"(1234.6)");
        harness.check(df.format(1234.56), (Object)"1234.6");
        this.apply(harness, df, "###0.#;###0.#-");
        harness.check(df.format(-1234.56), (Object)"1234.6-");
        harness.check(df.format(1234.56), (Object)"1234.6");
        this.apply(harness, df, "#,##0%;-#,##0%");
        harness.check(df.format(-1234.56), (Object)"-123,456%");
        harness.check(df.format(1234.56), (Object)"123,456%");
        this.apply(harness, df, "#.#");
        harness.check(df.format(0.2), (Object)"0.2");
        this.apply(harness, df, "'#'#.#");
        harness.check(df.format(30L), (Object)"#30");
        this.apply(harness, df, "000000");
        harness.check(df.format(-1234.567), (Object)"-001235");
        this.apply(harness, df, "##");
        harness.check(df.format(-1234.567), (Object)"-1235");
        harness.check(df.format(0L), (Object)"0");
        this.apply(harness, df, "##00");
        harness.check(df.format(0L), (Object)"00");
        this.apply(harness, df, ".00");
        harness.check(df.format(-0.567), (Object)"-.57");
        this.apply(harness, df, "0.00");
        harness.check(df.format(-0.567), (Object)"-0.57");
        this.apply(harness, df, ".######");
        harness.check(df.format(-1234.567), (Object)"-1234.567");
        this.apply(harness, df, "#.000000");
        harness.check(df.format(-1234.567), (Object)"-1234.567000");
        this.apply(harness, df, "'#'#");
        harness.check(df.format(-1234.567), (Object)"-#1235");
        this.apply(harness, df, "'abc'#");
        harness.check(df.format(-1234.567), (Object)"-abc1235");
        this.apply(harness, df, "'positive'#;'negative' -");
        harness.check(df.format(-1234.567), (Object)"negative -1235");
        harness.check(df.format(1234.567), (Object)"positive1235");
        this.apply(harness, df, "#,##0%");
        harness.check(df.format(1.00000001234E7), (Object)"1,000,000,012%");
        this.apply(harness, df, "\u00a4#,##0.00;(\u00a4#,##0.00)");
        harness.check(df.format(10000L), (Object)"$10,000.00");
        this.apply(harness, df, "$#,##0.00;($#,##0.00)");
        harness.check(df.format(10000L), (Object)"$10,000.00");
        harness.checkPoint("regression tests for setGroupingSize");
        df = new DecimalFormat();
        df.setGroupingSize(0);
        harness.check(df.format(100000L), (Object)"100000");
        harness.check(df.isGroupingUsed());
        harness.check(df.getGroupingSize(), 0);
    }

    private void testRounding(TestHarness harness) {
        harness.checkPoint("DecimalFormat rounding");
        Locale original = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        DecimalFormat f = new DecimalFormat("0.00");
        harness.check(f.format(1.225), (Object)"1.22");
        harness.check(f.format(1.235), (Object)"1.24");
        Locale.setDefault(original);
    }

    private void testMiscellaneous(TestHarness harness) {
        harness.checkPoint("DecimalFormat: misc");
        Locale original = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        DecimalFormat f = new DecimalFormat("0");
        boolean pass = false;
        try {
            f.format(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            f.format("XYZ");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            f.format(new Number(){

                @Override
                public float floatValue() {
                    return 0.0f;
                }

                @Override
                public double doubleValue() {
                    return 0.0;
                }

                @Override
                public long longValue() {
                    return 0L;
                }

                @Override
                public int intValue() {
                    return 0;
                }
            });
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
        Locale.setDefault(original);
    }

    private void testBigInteger(TestHarness harness) {
        Locale orig = Locale.getDefault();
        Locale.setDefault(Locale.US);
        harness.checkPoint("BigInteger format");
        String expect = "123,456,789,012,345,678,901,234,567,890";
        BigInteger bi = new BigInteger("123456789012345678901234567890", 10);
        DecimalFormat df = new DecimalFormat();
        harness.check(df.format(bi), (Object)expect);
        Locale.setDefault(orig);
    }

    private void testInfinity(TestHarness harness) {
        Locale orig = Locale.getDefault();
        Locale.setDefault(Locale.US);
        harness.checkPoint("testInfinity");
        String expectPositive = "\u221e";
        String expectNegative = "-\u221e";
        double positiveInf = Double.longBitsToDouble(0x7FF0000000000000L);
        double negativeInf = Double.longBitsToDouble(-4503599627370496L);
        DecimalFormat df = new DecimalFormat();
        harness.check(df.format(positiveInf), expectPositive, "positive inf.");
        harness.check(df.format(negativeInf), expectNegative, "negative inf.");
        Locale.setDefault(orig);
    }

    private void testNaN(TestHarness harness) {
        Locale orig = Locale.getDefault();
        Locale.setDefault(Locale.US);
        harness.checkPoint("testNaN");
        String expect = "\ufffd";
        double nan = Double.longBitsToDouble(9221120237041090560L);
        DecimalFormat df = new DecimalFormat();
        harness.check(df.format(nan), (Object)expect);
        harness.check(df.format(-nan), expect, "NaN with a negative sign as pefix");
        Locale.setDefault(orig);
    }

    private void testMaximumDigits(TestHarness harness) {
        Locale orig = Locale.getDefault();
        Locale.setDefault(Locale.US);
        harness.checkPoint("testMaxAndMinDigits");
        double number = 1.2345678998765433E8;
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(false);
        df.setGroupingSize(3);
        df.setMaximumIntegerDigits(2);
        df.setMaximumFractionDigits(4);
        harness.check(df.format(number), (Object)"89.9877");
        df.setMaximumIntegerDigits(5);
        df.setMaximumFractionDigits(0);
        harness.check(df.format(number), (Object)"56790");
        df.setMaximumIntegerDigits(0);
        df.setMaximumFractionDigits(5);
        harness.check(df.format(number), (Object)".98765");
        df.setMaximumIntegerDigits(-1);
        df.setMaximumFractionDigits(-1);
        harness.check(df.format(number), (Object)"0");
        df.setMaximumIntegerDigits(390);
        df.setMaximumFractionDigits(340);
        harness.check(df.format(number), (Object)"123456789.98765433");
        Locale.setDefault(orig);
    }

    private void testLocale(TestHarness harness) {
        harness.checkPoint("locale: GERMANY");
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        harness.check(nf.format(5000.25), (Object)"5.000,25 \u20ac");
        harness.checkPoint("locale: ITALY");
        nf = NumberFormat.getCurrencyInstance(Locale.ITALY);
        harness.check(nf.format(5000.25), (Object)"\u20ac 5.000,25");
        DecimalFormatSymbols symbols = ((DecimalFormat)nf).getDecimalFormatSymbols();
        harness.check(44, symbols.getDecimalSeparator());
        harness.check(44, symbols.getMonetaryDecimalSeparator());
        harness.check(46, symbols.getGroupingSeparator());
    }
}

