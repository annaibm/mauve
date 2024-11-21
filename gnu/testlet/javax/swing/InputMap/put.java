/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class put
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        KeyStroke ks1 = KeyStroke.getKeyStroke('a');
        m.put(ks1, "ABC");
        harness.check(m.get(ks1), (Object)"ABC");
        m.put(ks1, "DEF");
        harness.check(m.get(ks1), (Object)"DEF");
        m.put(ks1, null);
        harness.check(m.get(ks1), null);
        harness.check(m.size(), 0);
        m.put(null, "ZZZ");
        harness.check(m.get(null), null);
    }
}

