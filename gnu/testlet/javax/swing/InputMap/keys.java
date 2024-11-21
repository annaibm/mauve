/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class keys
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap map2 = new InputMap();
        KeyStroke[] k = map2.keys();
        harness.check(k, null);
        map2.put(KeyStroke.getKeyStroke('a'), "AAA");
        k = map2.keys();
        harness.check(k.length, 1);
        harness.check(k[0], KeyStroke.getKeyStroke('a'));
        map2.put(KeyStroke.getKeyStroke('b'), "BBB");
        k = map2.keys();
        harness.check(k.length, 2);
        harness.check(k[1], KeyStroke.getKeyStroke('b'));
        map2.put(KeyStroke.getKeyStroke('b'), null);
        k = map2.keys();
        harness.check(k.length, 1);
        harness.check(k[0], KeyStroke.getKeyStroke('a'));
        map2.clear();
        k = map2.keys();
        harness.check(k.length, 0);
        InputMap p = new InputMap();
        p.put(KeyStroke.getKeyStroke('z'), "ZZZ");
        map2.setParent(p);
        k = map2.keys();
        harness.check(k.length, 0);
    }
}

