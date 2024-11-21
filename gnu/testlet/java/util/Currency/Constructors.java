/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Currency;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Currency;
import java.util.Locale;

public class Constructors
implements Testlet {
    private static final String INVALID_CURRENCY_CODE = "GNU";
    private static final String UK_CURRENCY_CODE = "GBP";

    @Override
    public void test(TestHarness harness) {
        Currency currency;
        boolean threwException = false;
        try {
            currency = Currency.getInstance((String)null);
        }
        catch (NullPointerException exception) {
            threwException = true;
        }
        harness.check(threwException, "Currency instance request with null string exception check.");
        threwException = false;
        try {
            currency = Currency.getInstance(INVALID_CURRENCY_CODE);
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "Currency instance request with invalid currency code string exception check.");
        threwException = false;
        try {
            currency = Currency.getInstance((Locale)null);
        }
        catch (NullPointerException exception) {
            threwException = true;
        }
        harness.check(threwException, "Currency instance request with null locale exception check.");
    }
}

