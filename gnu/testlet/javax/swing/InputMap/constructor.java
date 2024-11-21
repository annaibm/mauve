/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        harness.check(m.size(), 0);
        harness.check(m.getParent(), null);
        harness.check(m.keys(), null);
        harness.check(m.allKeys(), null);
    }
}

