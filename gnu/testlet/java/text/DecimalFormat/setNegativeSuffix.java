/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class setNegativeSuffix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setNegativeSuffix("ABC");
        harness.check(f1.getNegativeSuffix(), (Object)"ABC");
        f1.setNegativeSuffix(null);
        harness.check(f1.getNegativeSuffix(), null);
    }
}

