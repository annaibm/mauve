/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.Collator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class Constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0, 0, "PRIMARY");
        harness.check(1, 1, "SECONDARY");
        harness.check(2, 2, "TERTIARY");
        harness.check(3, 3, "IDENTICAL");
        harness.check(0, 0, "NO_DECOMPOSITION");
        harness.check(1, 1, "CANONICAL_DECOMPOSITION");
        harness.check(2, 2, "FULL_DECOMPOSITION");
    }
}

