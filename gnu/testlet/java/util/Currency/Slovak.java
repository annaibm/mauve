/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Currency;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Currency;
import java.util.Locale;

public class Slovak
implements Testlet {
    private static final Locale TEST_LOCALE = new Locale("Slovak");
    private static final String ISO4217_CODE = "SKK";
    private static final String CURRENCY_SYMBOL = "SKK";
    private static final int FRACTION_DIGITS = 2;

    @Override
    public void test(TestHarness harness) {
        Locale.setDefault(TEST_LOCALE);
        Currency currency = Currency.getInstance("SKK");
        harness.check(currency.getCurrencyCode(), "SKK", "ISO 4217 currency code retrieval check (" + currency.getCurrencyCode() + ").");
        harness.check(currency.getSymbol(), "SKK", "Currency symbol retrieval check (" + currency.getSymbol() + ").");
        harness.check(currency.getDefaultFractionDigits(), 2, "Currency fraction digits retrieval check (" + currency.getDefaultFractionDigits() + ").");
        harness.check(currency.toString(), "SKK", "ISO 4217 currency code retrieval check (" + currency.toString() + ").");
    }
}

