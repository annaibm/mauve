/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DumpDefault11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        harness.debug("decimalSeparator=" + dfs.getDecimalSeparator());
        harness.debug("digit=" + dfs.getDigit());
        harness.debug("groupingSeparator=" + dfs.getGroupingSeparator());
        harness.debug("infinity=" + dfs.getInfinity());
        harness.debug("minusSign=" + dfs.getMinusSign());
        harness.debug("NaN=" + dfs.getNaN());
        harness.debug("patternSeparator=" + dfs.getPatternSeparator());
        harness.debug("percent=" + dfs.getPercent());
        harness.debug("perMill=" + dfs.getPerMill());
        harness.debug("zeroDigit=" + dfs.getZeroDigit());
    }
}

