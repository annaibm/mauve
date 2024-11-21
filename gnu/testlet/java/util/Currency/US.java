/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Currency;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Currency;
import java.util.Locale;

public class US
implements Testlet {
    private static final Locale TEST_LOCALE = Locale.US;
    private static final String ISO4217_CODE = "USD";
    private static final String CURRENCY_SYMBOL = "$";
    private static final String NON_LOCAL_CURRENCY_SYMBOL = "US$";
    private static final int FRACTION_DIGITS = 2;

    @Override
    public void test(TestHarness harness) {
        Currency currency = Currency.getInstance(TEST_LOCALE);
        harness.check(currency.getCurrencyCode(), ISO4217_CODE, "ISO 4217 currency code retrieval check (" + currency.getCurrencyCode() + ").");
        harness.check(currency.getSymbol(Locale.US), CURRENCY_SYMBOL, "Currency symbol retrieval check (" + currency.getSymbol(Locale.US) + ").");
        harness.check(currency.getSymbol(Locale.CANADA), NON_LOCAL_CURRENCY_SYMBOL, "Non local currency symbol retrieval check (" + currency.getSymbol(Locale.CANADA) + ").");
        harness.check(currency.getDefaultFractionDigits(), 2, "Currency fraction digits retrieval check (" + currency.getDefaultFractionDigits() + ").");
        harness.check(currency.toString(), ISO4217_CODE, "ISO 4217 currency code retrieval check (" + currency.toString() + ").");
    }
}

