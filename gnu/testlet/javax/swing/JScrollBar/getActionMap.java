/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JScrollBar;

public class getActionMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JScrollBar sb = new JScrollBar();
        ActionMap m = sb.getActionMap();
        harness.check(m.keys(), null);
        ActionMap mp = m.getParent();
        harness.check(mp.get("positiveUnitIncrement") instanceof Action);
        harness.check(mp.get("positiveBlockIncrement") instanceof Action);
        harness.check(mp.get("negativeUnitIncrement") instanceof Action);
        harness.check(mp.get("negativeBlockIncrement") instanceof Action);
        harness.check(mp.get("minScroll") instanceof Action);
        harness.check(mp.get("maxScroll") instanceof Action);
        harness.check(mp.keys().length, 6);
    }
}

