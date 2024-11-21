/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        KeyStroke ks1 = KeyStroke.getKeyStroke('a');
        m.remove(ks1);
        harness.check(m.get(ks1), null);
        m.put(ks1, "ABC");
        harness.check(m.get(ks1), (Object)"ABC");
        m.remove(ks1);
        harness.check(m.get(ks1), null);
        m.remove(null);
        harness.check(m.size(), 0);
        m.put(ks1, "ABC");
        m.remove(null);
        harness.check(m.size(), 1);
        KeyStroke ks2 = KeyStroke.getKeyStroke('b');
        InputMap p = new InputMap();
        p.put(ks2, "ZZZ");
        m.setParent(p);
        m.remove(ks2);
        harness.check(m.get(ks2), (Object)"ZZZ");
    }
}

