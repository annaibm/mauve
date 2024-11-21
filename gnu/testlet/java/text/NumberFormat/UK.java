/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.NumberFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class UK
implements Testlet {
    private static final Locale TEST_LOCALE = Locale.UK;
    private static final String EXPECTED_GROUPED_NUMBER = "123,456.789";
    private static final String EXPECTED_INT_GROUP_NUMBER = "123,457";
    private static final String EXPECTED_PER_GROUP_NUMBER = "12,345,678.9%";
    private static final String CURRENCY_SYMBOL = "\u00a3";
    private static final boolean CURRENCY_PREFIXED = true;
    private static final String DECIMAL_SEP = ".";
    private static final String CURRENCY_SUFFIX = ".00";
    private static final String GROUPED_PERCENTILE = "3,000%";

    @Override
    public void test(TestHarness harness) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(TEST_LOCALE);
        this.setOptions(numberFormat, false);
        long testLong = 30L;
        String testString = numberFormat.format(testLong);
        harness.check(testString, "30", "Long-based integer formatting with normal number format (" + testString + ").");
        double testDouble = 30.0;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "30", "Double-based integer formatting with normal number format (" + testString + ").");
        testDouble = 0.3333333333333333;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "0.333", "Double-based fraction formatting with normal number format (" + testString + ").");
        testDouble = 123456.789;
        testString = numberFormat.format(testDouble);
        harness.check(testString, EXPECTED_GROUPED_NUMBER, "Double-based fraction formatting with normal number format (" + testString + ").");
        numberFormat = NumberFormat.getIntegerInstance(TEST_LOCALE);
        this.setOptions(numberFormat, true);
        testLong = 30L;
        testString = numberFormat.format(testLong);
        harness.check(testString, "30", "Long-based integer formatting with integer number format (" + testString + ").");
        testDouble = 30.0;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "30", "Double-based integer formatting with integer number format (" + testString + ").");
        testDouble = 0.3333333333333333;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "0", "Double-based fraction formatting with integer number format (" + testString + ").");
        testDouble = 123456.789;
        testString = numberFormat.format(testDouble);
        harness.check(testString, EXPECTED_INT_GROUP_NUMBER, "Double-based fraction formatting with integer number format (" + testString + ").");
        numberFormat = NumberFormat.getCurrencyInstance(TEST_LOCALE);
        this.setOptions(numberFormat, false);
        testLong = 30L;
        testString = numberFormat.format(testLong);
        harness.check(testString, "\u00a330.00", "Long-based integer formatting with currency number format (" + testString + ").");
        testDouble = 30.0;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "\u00a330.00", "Double-based integer formatting with currency number format (" + testString + ").");
        testDouble = 0.3333333333333333;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "\u00a30.333", "Double-based fraction formatting with currency number format (" + testString + ").");
        testDouble = 123456.789;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "\u00a3123,456.789", "Double-based fraction formatting with currency number format (" + testString + ").");
        numberFormat = NumberFormat.getPercentInstance(TEST_LOCALE);
        this.setOptions(numberFormat, false);
        testLong = 30L;
        testString = numberFormat.format(testLong);
        harness.check(testString, GROUPED_PERCENTILE, "Long-based integer formatting with percentile number format (" + testString + ").");
        testDouble = 30.0;
        testString = numberFormat.format(testDouble);
        harness.check(testString, GROUPED_PERCENTILE, "Double-based integer formatting with percentile number format (" + testString + ").");
        testDouble = 0.3333333333333333;
        testString = numberFormat.format(testDouble);
        harness.check(testString, "33.333%", "Double-based fraction formatting with percentile number format (" + testString + ").");
        testDouble = 123456.789;
        testString = numberFormat.format(testDouble);
        harness.check(testString, EXPECTED_PER_GROUP_NUMBER, "Double-based fraction formatting with percentile number format (" + testString + ").");
    }

    public void setOptions(NumberFormat formatter, boolean integer) {
        if (!integer) {
            formatter.setMaximumFractionDigits(3);
        }
        formatter.setGroupingUsed(true);
        try {
            ((DecimalFormat)formatter).setDecimalSeparatorAlwaysShown(false);
        }
        catch (ClassCastException classCastException) {
            // empty catch block
        }
    }
}

