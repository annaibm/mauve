/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class getPositivePrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setPositivePrefix("XYZ");
        harness.check(f1.getPositivePrefix(), (Object)"XYZ");
        String longPrefix = "'#'1'.' ''nessuno ci capisce niente qui";
        String longPrefixCheck = "#1. 'nessuno ci capisce niente qui";
        DecimalFormat f2 = new DecimalFormat(longPrefix + "#0.00;(#0.00)");
        harness.check(f2.getPositivePrefix(), (Object)longPrefixCheck);
    }
}

