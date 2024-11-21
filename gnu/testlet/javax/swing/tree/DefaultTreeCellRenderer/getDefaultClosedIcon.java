/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.tree.DefaultTreeCellRenderer;

public class getDefaultClosedIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        harness.check(r.getDefaultClosedIcon(), UIManager.get("Tree.closedIcon"));
        UIManager.put("Tree.closedIcon", MetalIconFactory.getCheckBoxIcon());
        harness.check(r.getDefaultClosedIcon(), MetalIconFactory.getCheckBoxIcon());
    }
}

