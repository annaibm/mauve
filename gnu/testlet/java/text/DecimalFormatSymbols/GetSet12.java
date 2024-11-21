/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GetSet12
implements Testlet {
    private String currencySymbol = "@";
    private String intlCurrencySymbol = "#";
    private char monetarySeparator = (char)44;

    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.setCurrencySymbol(this.currencySymbol);
        harness.check(dfs.getCurrencySymbol(), this.currencySymbol, "currencySymbol");
        dfs.setInternationalCurrencySymbol(this.intlCurrencySymbol);
        harness.check(dfs.getInternationalCurrencySymbol(), this.intlCurrencySymbol, "intlCurrencySymbol");
        dfs.setMonetaryDecimalSeparator(this.monetarySeparator);
        harness.check(dfs.getMonetaryDecimalSeparator(), this.monetarySeparator, "monetarySeparator");
    }
}

