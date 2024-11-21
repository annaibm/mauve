/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.VariableHeightLayoutCache;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.VariableHeightLayoutCache;

public class getBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNullRect(harness);
    }

    private void testNullRect(TestHarness h) {
        VariableHeightLayoutCache c = new VariableHeightLayoutCache();
        DefaultMutableTreeNode n = new DefaultMutableTreeNode();
        TreePath p = new TreePath(n);
        DefaultTreeModel m = new DefaultTreeModel(n);
        c.setModel(m);
        Rectangle r = new Rectangle();
        Rectangle s = c.getBounds(p, r);
        h.check(r == s);
        s = c.getBounds(p, null);
        h.check(s != null);
        h.check(s != r);
    }
}

