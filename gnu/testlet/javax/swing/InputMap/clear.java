/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class clear
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        m.clear();
        harness.check(m.size(), 0);
        m.put(KeyStroke.getKeyStroke('a'), "AAA");
        harness.check(m.size(), 1);
        m.clear();
        harness.check(m.size(), 0);
        InputMap p = new InputMap();
        p.put(KeyStroke.getKeyStroke('z'), "ZZZ");
        harness.check(p.size(), 1);
        m.setParent(p);
        m.clear();
        harness.check(p.size(), 1);
    }
}

