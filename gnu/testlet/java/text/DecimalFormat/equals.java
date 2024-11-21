/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        DecimalFormat f2 = new DecimalFormat();
        harness.check(f1.equals(f2));
        harness.check(f2.equals(f1));
        f1.applyPattern("#,##0");
        f2.applyPattern("#,##0.00");
        harness.check(!f1.equals(f2));
        f2.applyPattern("#,##0");
        harness.check(f1.equals(f2));
        f1.setDecimalSeparatorAlwaysShown(!f1.isDecimalSeparatorAlwaysShown());
        harness.check(!f1.equals(f2));
        f2.setDecimalSeparatorAlwaysShown(f1.isDecimalSeparatorAlwaysShown());
        harness.check(f1.equals(f2));
        f1.setGroupingSize(5);
        harness.check(!f1.equals(f2));
        f2.setGroupingSize(5);
        harness.check(f1.equals(f2));
        f1.setGroupingUsed(!f1.isGroupingUsed());
        harness.check(!f1.equals(f2));
        f2.setGroupingUsed(f1.isGroupingUsed());
        harness.check(f1.equals(f2));
        f1.setMaximumFractionDigits(12);
        harness.check(!f1.equals(f2));
        f2.setMaximumFractionDigits(12);
        harness.check(f1.equals(f2));
        f1.setMaximumIntegerDigits(23);
        harness.check(!f1.equals(f2));
        f2.setMaximumIntegerDigits(23);
        harness.check(f1.equals(f2));
        f1.setMinimumFractionDigits(5);
        harness.check(!f1.equals(f2));
        f2.setMinimumFractionDigits(5);
        harness.check(f1.equals(f2));
        f1.setMinimumIntegerDigits(4);
        harness.check(!f1.equals(f2));
        f2.setMinimumIntegerDigits(4);
        harness.check(f1.equals(f2));
        f1.setMultiplier(17);
        harness.check(!f1.equals(f2));
        f2.setMultiplier(17);
        harness.check(f1.equals(f2));
        f1.setNegativePrefix("ABC");
        harness.check(!f1.equals(f2));
        f2.setNegativePrefix("ABC");
        harness.check(f1.equals(f2));
        f1.setPositivePrefix("XYZ");
        harness.check(!f1.equals(f2));
        f2.setPositivePrefix("XYZ");
        harness.check(f1.equals(f2));
        f1.setNegativeSuffix("FGH");
        harness.check(!f1.equals(f2));
        f2.setNegativeSuffix("FGH");
        harness.check(f1.equals(f2));
        f1.setPositiveSuffix("JKL");
        harness.check(!f1.equals(f2));
        f2.setPositiveSuffix("JKL");
        harness.check(f1.equals(f2));
        f1.applyPattern("0.00");
        f2.applyPattern("0.00;-0.00");
        harness.check(f1.equals(f2));
        harness.check(!f1.equals(null));
        harness.check(!f1.equals("Not a DecimalFormat"));
    }
}

