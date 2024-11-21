/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PR27311
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.ENGLISH);
        DecimalFormat nf = new DecimalFormat("0.0#####E00", dfs);
        nf.setGroupingUsed(false);
        String result = nf.format(0.0);
        harness.check(result.equals("0.0E00"), result);
    }
}

