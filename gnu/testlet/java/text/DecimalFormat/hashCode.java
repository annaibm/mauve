/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat("0.00");
        DecimalFormat f2 = new DecimalFormat("0.00");
        harness.check(f1.equals(f2));
        harness.check(f1.hashCode(), f2.hashCode());
    }
}

