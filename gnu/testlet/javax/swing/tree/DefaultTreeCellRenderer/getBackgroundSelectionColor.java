/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getBackgroundSelectionColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getBackgroundSelectionColor(), UIManager.getColor("Tree.selectionBackground"));
        r.setBackgroundSelectionColor(null);
        harness.check(r.getBackgroundSelectionColor(), null);
    }
}

