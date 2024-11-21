/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(2, 2);
        harness.check(3, 3);
        harness.check(0, 0);
        harness.check(1, 1);
    }
}

