/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class size
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        harness.check(m.size(), 0);
        m.put(KeyStroke.getKeyStroke('a'), "ABC");
        harness.check(m.size(), 1);
        m.put(KeyStroke.getKeyStroke('b'), "DEF");
        harness.check(m.size(), 2);
        InputMap p = new InputMap();
        p.put(KeyStroke.getKeyStroke('c'), "GHI");
        m.setParent(p);
        harness.check(m.size(), 2);
        m.clear();
        harness.check(m.size(), 0);
    }
}

