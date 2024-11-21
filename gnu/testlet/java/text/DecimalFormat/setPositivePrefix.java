/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class setPositivePrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setPositivePrefix("ABC");
        harness.check(f1.getPositivePrefix(), (Object)"ABC");
        f1.setPositivePrefix(null);
        harness.check(f1.getPositivePrefix(), null);
    }
}

