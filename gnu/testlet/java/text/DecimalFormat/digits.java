/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class digits
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);
        harness.check(df.getMaximumFractionDigits(), 1);
        df.setMaximumFractionDigits(350);
        harness.check(df.getMaximumFractionDigits(), 350);
        df.setMinimumFractionDigits(1);
        harness.check(df.getMinimumFractionDigits(), 1);
        df.setMinimumFractionDigits(350);
        harness.check(df.getMinimumFractionDigits(), 350);
        df.setMinimumFractionDigits(16);
        df.setMaximumFractionDigits(12);
        harness.check(df.getMinimumFractionDigits(), 12);
        df.setMaximumFractionDigits(12);
        df.setMinimumFractionDigits(16);
        harness.check(df.getMinimumFractionDigits(), 16);
        df.setMaximumIntegerDigits(1);
        harness.check(df.getMaximumIntegerDigits(), 1);
        df.setMaximumIntegerDigits(310);
        harness.check(df.getMaximumIntegerDigits(), 310);
        df.setMinimumIntegerDigits(1);
        harness.check(df.getMinimumIntegerDigits(), 1);
        df.setMinimumIntegerDigits(310);
        harness.check(df.getMinimumIntegerDigits(), 310);
        df.setMinimumIntegerDigits(16);
        df.setMaximumIntegerDigits(12);
        harness.check(df.getMinimumIntegerDigits(), 12);
        df.setMaximumIntegerDigits(12);
        df.setMinimumIntegerDigits(16);
        harness.check(df.getMinimumIntegerDigits(), 16);
    }
}

