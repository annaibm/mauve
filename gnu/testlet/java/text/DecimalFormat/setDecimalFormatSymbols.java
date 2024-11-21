/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class setDecimalFormatSymbols
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('x');
        f1.setDecimalFormatSymbols(symbols);
        harness.check(f1.getDecimalFormatSymbols().getDecimalSeparator(), 120);
        symbols.setDecimalSeparator('y');
        harness.check(f1.getDecimalFormatSymbols().getDecimalSeparator(), 120);
        boolean pass = false;
        try {
            f1.setDecimalFormatSymbols(null);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }
}

