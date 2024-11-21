/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getBackgroundNonSelectionColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getBackgroundNonSelectionColor(), UIManager.getColor("Tree.textBackground"));
        r.setBackgroundNonSelectionColor(null);
        harness.check(r.getBackgroundNonSelectionColor(), null);
        UIManager.put("Tree.textBackground", Color.red);
        DefaultTreeCellRenderer r2 = new DefaultTreeCellRenderer();
        harness.check(r2.getBackgroundNonSelectionColor(), Color.red);
    }
}

