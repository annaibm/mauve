/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class getDecimalFormatSymbols
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols symbols2;
        DecimalFormat f1 = new DecimalFormat();
        DecimalFormatSymbols symbols1 = f1.getDecimalFormatSymbols();
        harness.check(symbols1 != (symbols2 = f1.getDecimalFormatSymbols()));
        harness.check(symbols1.equals(symbols2));
    }
}

