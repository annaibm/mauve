/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        DecimalFormat f2 = (DecimalFormat)f1.clone();
        harness.check(f1 != f2);
        harness.check(f1.equals(f2));
    }
}

