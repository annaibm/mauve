/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class setNegativePrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setNegativePrefix("ABC");
        harness.check(f1.getNegativePrefix(), (Object)"ABC");
        f1.setNegativePrefix(null);
        harness.check(f1.getNegativePrefix(), null);
    }
}

