/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;

public class isNodeRelated
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        h.check(!node.isNodeRelated(null));
        h.check(!node.isNodeRelated(DefaultMutableTreeNodeTest.A));
        Vector nodes = DefaultMutableTreeNodeTest.nodes;
        for (int i = 0; i < nodes.size(); ++i) {
            for (int j = 0; j < nodes.size(); ++j) {
                DefaultMutableTreeNode node1 = (DefaultMutableTreeNode)nodes.get(i);
                DefaultMutableTreeNode node2 = (DefaultMutableTreeNode)nodes.get(j);
                h.check(node1.isNodeRelated(node2), "isNodeRelated");
            }
        }
    }
}

