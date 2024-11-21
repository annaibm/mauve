/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class setDecimalSeparatorAlwaysShown
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setDecimalSeparatorAlwaysShown(true);
        harness.check(f1.isDecimalSeparatorAlwaysShown());
        f1.setDecimalSeparatorAlwaysShown(false);
        harness.check(!f1.isDecimalSeparatorAlwaysShown());
    }
}

