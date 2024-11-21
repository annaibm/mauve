/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.NumberFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class PR31895
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);
        Currency cur = Currency.getInstance(Locale.UK);
        harness.check(nf.format(2.5).startsWith(cur.getSymbol()), nf.format(2.5) + " begins with " + cur.getSymbol());
        Currency newCur = Currency.getInstance("EUR");
        nf.setCurrency(newCur);
        harness.check(nf.format(2.5).startsWith(newCur.getSymbol()), nf.format(2.5) + " begins with " + newCur.getSymbol());
    }
}

