/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;

public class getParent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        harness.check(m.getParent(), null);
        InputMap p = new InputMap();
        m.setParent(p);
        harness.check(m.getParent(), p);
        m.setParent(null);
        harness.check(m.getParent(), null);
    }
}

