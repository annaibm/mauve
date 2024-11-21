/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.util.Locale;

public class MaximumAndMinimumDigits
implements Testlet {
    private TestHarness harness = null;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        Locale original = Locale.getDefault();
        Locale.setDefault(Locale.US);
        try {
            this.doTest();
        }
        finally {
            Locale.setDefault(original);
        }
    }

    private void doTest() {
        int MAX = Integer.MAX_VALUE;
        this.harness.checkPoint("default pattern");
        DecimalFormat format2 = new DecimalFormat();
        this.harness.check(format2.getMaximumIntegerDigits(), MAX);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 3);
        this.harness.check(format2.getMinimumFractionDigits(), 0);
        this.harness.checkPoint("0.00E0");
        format2 = new DecimalFormat("0.00E0");
        this.harness.check(format2.getMaximumIntegerDigits(), 1);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 2);
        this.harness.check(format2.getMinimumFractionDigits(), 2);
        this.harness.checkPoint("#,##0.0#");
        format2 = new DecimalFormat("#,##0.0#");
        this.harness.check(format2.getMaximumIntegerDigits(), MAX);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 2);
        this.harness.check(format2.getMinimumFractionDigits(), 1);
        this.harness.checkPoint("maximum integer digits, checking format...");
        format2.setMaximumIntegerDigits(0);
        this.harness.check(format2.getMaximumIntegerDigits(), 0);
        this.harness.check(format2.format(123456.123456), (Object)".12");
        this.harness.checkPoint("#.");
        format2 = new DecimalFormat("#.");
        this.harness.check(format2.getMaximumIntegerDigits(), MAX);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 0);
        this.harness.check(format2.getMinimumFractionDigits(), 0);
        this.harness.checkPoint("#.#");
        format2 = new DecimalFormat("#.#");
        this.harness.check(format2.getMaximumIntegerDigits(), MAX);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 1);
        this.harness.check(format2.getMinimumFractionDigits(), 0);
        this.harness.checkPoint("#0000000000000,00000.###");
        format2 = new DecimalFormat("#0000000000000,00000.###");
        this.harness.check(format2.getMaximumIntegerDigits(), MAX);
        this.harness.check(format2.getMinimumIntegerDigits(), 18);
        this.harness.check(format2.getMaximumFractionDigits(), 3);
        this.harness.check(format2.getMinimumFractionDigits(), 0);
        this.harness.checkPoint("0E0");
        format2 = new DecimalFormat("0E0");
        this.harness.check(format2.getMaximumIntegerDigits(), 1);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 0);
        this.harness.check(format2.getMinimumFractionDigits(), 0);
        this.harness.checkPoint("0.###E0");
        format2 = new DecimalFormat("0.###E0");
        this.harness.check(format2.getMaximumIntegerDigits(), 1);
        this.harness.check(format2.getMinimumIntegerDigits(), 1);
        this.harness.check(format2.getMaximumFractionDigits(), 3);
        this.harness.check(format2.getMinimumFractionDigits(), 0);
        this.harness.checkPoint(".00");
        format2 = new DecimalFormat(".00");
        this.harness.check(format2.getMaximumIntegerDigits(), MAX);
        this.harness.check(format2.getMinimumIntegerDigits(), 0);
        this.harness.check(format2.getMaximumFractionDigits(), 2);
        this.harness.check(format2.getMinimumFractionDigits(), 2);
    }
}

