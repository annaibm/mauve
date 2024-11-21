/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getOpenIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getOpenIcon(), r.getDefaultOpenIcon());
        r.setOpenIcon(null);
        harness.check(r.getOpenIcon(), null);
    }
}

