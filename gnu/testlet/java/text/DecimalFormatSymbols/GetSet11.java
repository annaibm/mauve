/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GetSet11
implements Testlet {
    private char decimalSeparator = (char)44;
    private char digit = (char)57;
    private char groupingSeparator = (char)46;
    private char patternSeparator = (char)45;
    private String infinity = "infinity";
    private String NaN = "NaN";
    private char minusSign = (char)43;
    private char percent = (char)35;
    private char perMill = (char)33;
    private char zeroDigit = (char)79;

    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.setDecimalSeparator(this.decimalSeparator);
        harness.check(dfs.getDecimalSeparator(), this.decimalSeparator, "decimalSeparator");
        dfs.setDigit(this.digit);
        harness.check(dfs.getDigit(), this.digit, "digit");
        dfs.setGroupingSeparator(this.groupingSeparator);
        harness.check(dfs.getGroupingSeparator(), this.groupingSeparator, "groupingSeparator");
        dfs.setInfinity(this.infinity);
        harness.check(dfs.getInfinity(), this.infinity, "infinity");
        dfs.setMinusSign(this.minusSign);
        harness.check(dfs.getMinusSign(), this.minusSign, "minusSign");
        dfs.setNaN(this.NaN);
        harness.check(dfs.getNaN(), this.NaN, "NaN");
        dfs.setPatternSeparator(this.patternSeparator);
        harness.check(dfs.getPatternSeparator(), this.patternSeparator, "patternSeparator");
        dfs.setPercent(this.percent);
        harness.check(dfs.getPercent(), this.percent, "percent");
        dfs.setPerMill(this.perMill);
        harness.check(dfs.getPerMill(), this.perMill, "perMill");
        dfs.setZeroDigit(this.zeroDigit);
        harness.check(dfs.getZeroDigit(), this.zeroDigit, "zeroDigit");
    }
}

