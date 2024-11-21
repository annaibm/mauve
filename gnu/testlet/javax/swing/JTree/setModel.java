/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTree;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class setModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("setModel(TreeModel)");
        DefaultTreeModel m1 = new DefaultTreeModel(new DefaultMutableTreeNode());
        JTree t = new JTree(m1);
        harness.check(t.getModel(), m1);
        DefaultTreeModel m2 = new DefaultTreeModel(new DefaultMutableTreeNode());
        t.setModel(m2);
        harness.check(t.getModel(), m2);
        t.setModel(null);
        harness.check(t.getModel(), null);
    }
}

