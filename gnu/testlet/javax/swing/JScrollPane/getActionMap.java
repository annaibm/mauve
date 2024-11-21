/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JScrollPane;

public class getActionMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JScrollPane p = new JScrollPane();
        ActionMap m = p.getActionMap();
        harness.check(m.keys(), null);
        ActionMap mp = m.getParent();
        harness.check(mp.get("scrollLeft") instanceof Action);
        harness.check(mp.get("scrollEnd") instanceof Action);
        harness.check(mp.get("unitScrollUp") instanceof Action);
        harness.check(mp.get("unitScrollLeft") instanceof Action);
        harness.check(mp.get("scrollUp") instanceof Action);
        harness.check(mp.get("scrollRight") instanceof Action);
        harness.check(mp.get("scrollHome") instanceof Action);
        harness.check(mp.get("scrollDown") instanceof Action);
        harness.check(mp.get("unitScrollDown") instanceof Action);
        harness.check(mp.get("unitScrollRight") instanceof Action);
    }
}

