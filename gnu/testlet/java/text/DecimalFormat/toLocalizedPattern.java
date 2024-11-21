/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class toLocalizedPattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f = new DecimalFormat("\u00a4#,##0.00", new DecimalFormatSymbols(Locale.UK));
        harness.check(f.toLocalizedPattern(), (Object)"\u00a4#,##0.00");
    }
}

