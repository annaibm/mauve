/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JMenuBar;

public class getActionMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        ActionMap m = mb.getActionMap();
        harness.check(m.keys(), null);
        ActionMap mp = m.getParent();
        harness.check(mp.get("takeFocus") instanceof Action);
        harness.check(mp.keys().length, 1);
    }
}

