/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class get
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap m = new InputMap();
        KeyStroke ks1 = KeyStroke.getKeyStroke('a');
        harness.check(m.get(ks1), null);
        m.put(ks1, "ABC");
        harness.check(m.get(ks1), (Object)"ABC");
        harness.check(m.get(null), null);
        InputMap p = new InputMap();
        KeyStroke ks2 = KeyStroke.getKeyStroke('b');
        p.put(ks2, "XYZ");
        m.setParent(p);
        harness.check(m.get(ks2), (Object)"XYZ");
    }
}

