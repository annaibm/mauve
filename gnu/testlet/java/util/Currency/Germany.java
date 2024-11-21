/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Currency;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;

public class Germany
implements Testlet {
    private static final Locale TEST_LOCALE = Locale.GERMANY;
    private static final String ISO4217_CODE = "DEM";
    private static final String CURRENCY_SYMBOL = "DM";
    private static final int FRACTION_DIGITS = 2;
    private static final String EURO_ISO4217_CODE = "EUR";
    private static final String EURO_CURRENCY_SYMBOL = "\u20ac";
    private static final int EURO_FRACTION_DIGITS = 2;
    private static final int EURO_CHANGE_YEAR = 2002;
    private static final int EURO_CHANGE_MONTH = 0;
    private static final int EURO_CHANGE_DATE = 1;

    @Override
    public void test(TestHarness harness) {
        Locale.setDefault(TEST_LOCALE);
        Currency currency = Currency.getInstance(TEST_LOCALE);
        Calendar calendar = Calendar.getInstance(TEST_LOCALE);
        Calendar euroCalendar = Calendar.getInstance(TEST_LOCALE);
        euroCalendar.set(2002, 0, 1);
        if (calendar.after(euroCalendar)) {
            harness.check(currency.getCurrencyCode(), EURO_ISO4217_CODE, "Euro ISO 4217 currency code retrieval check (" + currency.getCurrencyCode() + ").");
            harness.check(currency.getSymbol(), EURO_CURRENCY_SYMBOL, "Euro currency symbol retrieval check (" + currency.getSymbol() + ").");
            harness.check(currency.getDefaultFractionDigits(), 2, "Euro currency fraction digits retrieval check (" + currency.getDefaultFractionDigits() + ").");
            harness.check(currency.toString(), EURO_ISO4217_CODE, "Euro ISO 4217 currency code retrieval check (" + currency.toString() + ").");
        } else {
            harness.check(currency.getCurrencyCode(), ISO4217_CODE, "ISO 4217 currency code retrieval check (" + currency.getCurrencyCode() + ").");
            harness.check(currency.getSymbol(), CURRENCY_SYMBOL, "Currency symbol retrieval check (" + currency.getSymbol() + ").");
            harness.check(currency.getDefaultFractionDigits(), 2, "Currency fraction digits retrieval check (" + currency.getDefaultFractionDigits() + ").");
            harness.check(currency.toString(), ISO4217_CODE, "ISO 4217 currency code retrieval check (" + currency.toString() + ").");
        }
    }
}

