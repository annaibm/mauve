/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Currency;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Currency;
import java.util.Locale;

public class Japan
implements Testlet {
    private static final Locale TEST_LOCALE = Locale.JAPAN;
    private static final String ISO4217_CODE = "JPY";
    private static final String CURRENCY_SYMBOL = "\uffe5";
    private static final int FRACTION_DIGITS = 0;

    @Override
    public void test(TestHarness harness) {
        Locale.setDefault(TEST_LOCALE);
        Currency currency = Currency.getInstance(TEST_LOCALE);
        harness.check(currency.getCurrencyCode(), ISO4217_CODE, "ISO 4217 currency code retrieval check (" + currency.getCurrencyCode() + ").");
        harness.check(currency.getSymbol(), CURRENCY_SYMBOL, "Currency symbol retrieval check (" + currency.getSymbol() + ").");
        harness.check(currency.getDefaultFractionDigits(), 0, "Currency fraction digits retrieval check (" + currency.getDefaultFractionDigits() + ").");
        harness.check(currency.toString(), ISO4217_CODE, "ISO 4217 currency code retrieval check (" + currency.toString() + ").");
    }
}

