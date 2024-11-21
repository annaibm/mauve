/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Currency;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Currency;
import java.util.Locale;

public class ReferenceEquality
implements Testlet {
    private static final String UK_CURRENCY_CODE = "GBP";

    @Override
    public void test(TestHarness harness) {
        Currency currency2;
        Currency currency1 = Currency.getInstance(Locale.UK);
        harness.check(currency1 == (currency2 = Currency.getInstance(Locale.UK)), "Reference equality for currencies (UK) check.");
        currency2 = Currency.getInstance(UK_CURRENCY_CODE);
        harness.check(currency1 == currency2);
    }
}

