/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class allKeys
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        harness.check(m.allKeys(), null);
        KeyStroke ks1 = KeyStroke.getKeyStroke('a');
        m.put(ks1, "AAA");
        KeyStroke[] keys2 = m.allKeys();
        harness.check(keys2.length, 1);
        harness.check(keys2[0], ks1);
        InputMap p = new InputMap();
        m.setParent(p);
        keys2 = m.allKeys();
        harness.check(keys2.length, 1);
        harness.check(keys2[0], ks1);
        KeyStroke ks2 = KeyStroke.getKeyStroke('b');
        p.put(ks2, "BBB");
        keys2 = m.allKeys();
        harness.check(keys2.length, 2);
        harness.check(keys2[0], ks2);
        harness.check(keys2[1], ks1);
        KeyStroke ks3 = KeyStroke.getKeyStroke('z');
        p.put(ks3, "ZZZ");
        m.put(ks3, "XXX");
        keys2 = m.allKeys();
        harness.check(keys2.length, 3);
        harness.check(keys2[0], ks2);
        harness.check(keys2[1], ks3);
        harness.check(keys2[2], ks1);
    }
}

