/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;

public class setCurrency
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setCurrency(Currency.getInstance("NZD"));
        harness.check(f1.getCurrency(), Currency.getInstance("NZD"));
        DecimalFormatSymbols dfs = f1.getDecimalFormatSymbols();
        harness.check(dfs.getCurrency(), Currency.getInstance("NZD"));
        boolean pass = false;
        try {
            f1.setCurrency(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

