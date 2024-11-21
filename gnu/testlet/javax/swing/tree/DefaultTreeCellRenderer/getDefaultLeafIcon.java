/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getDefaultLeafIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getDefaultLeafIcon(), UIManager.get("Tree.leafIcon"));
        UIManager.put("Tree.leafIcon", MetalIconFactory.getCheckBoxIcon());
        harness.check(r.getDefaultLeafIcon(), MetalIconFactory.getCheckBoxIcon());
    }
}

