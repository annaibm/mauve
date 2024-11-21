/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getClosedIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getClosedIcon(), r.getDefaultClosedIcon());
        r.setClosedIcon(null);
        harness.check(r.getClosedIcon(), null);
    }
}

