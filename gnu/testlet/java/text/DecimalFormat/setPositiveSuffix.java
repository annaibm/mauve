/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class setPositiveSuffix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setPositiveSuffix("ABC");
        harness.check(f1.getPositiveSuffix(), (Object)"ABC");
        f1.setPositiveSuffix(null);
        harness.check(f1.getPositiveSuffix(), null);
    }
}

