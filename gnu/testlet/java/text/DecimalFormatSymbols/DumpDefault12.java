/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DumpDefault12
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        harness.debug("currencySymbol=" + dfs.getCurrencySymbol());
        harness.debug("intlCurrencySymbol=" + dfs.getInternationalCurrencySymbol());
        harness.debug("monetarySeparator=" + dfs.getMonetaryDecimalSeparator());
    }
}

