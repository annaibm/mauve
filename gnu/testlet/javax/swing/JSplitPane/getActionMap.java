/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ActionMap;
import javax.swing.JSplitPane;

public class getActionMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSplitPane sp = new JSplitPane();
        ActionMap m = sp.getActionMap();
        harness.check(m.keys(), null);
        ActionMap mp = m.getParent();
        harness.check(mp.get("negativeIncrement") != null);
        harness.check(mp.get("positiveIncrement") != null);
        harness.check(mp.get("selectMin") != null);
        harness.check(mp.get("selectMax") != null);
        harness.check(mp.get("startResize") != null);
        harness.check(mp.get("toggleFocus") != null);
        harness.check(mp.get("focusOutForward") != null);
        harness.check(mp.get("focusOutBackward") != null);
    }
}

