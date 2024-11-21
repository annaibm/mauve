/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.util.Currency;

public class getCurrency
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setCurrency(Currency.getInstance("GBP"));
        harness.check(f1.getCurrency(), Currency.getInstance("GBP"));
    }
}

