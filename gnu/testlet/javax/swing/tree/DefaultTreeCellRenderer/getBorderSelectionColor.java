/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getBorderSelectionColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getBorderSelectionColor(), UIManager.getColor("Tree.selectionBorderColor"));
        r.setBorderSelectionColor(null);
        harness.check(r.getBorderSelectionColor(), null);
    }
}

