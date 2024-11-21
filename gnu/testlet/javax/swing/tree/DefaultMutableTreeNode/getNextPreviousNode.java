/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;

public class getNextPreviousNode
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(DefaultMutableTreeNodeTest.A.getPreviousNode(), null);
        h.check(DefaultMutableTreeNodeTest.A.getNextNode(), DefaultMutableTreeNodeTest.B);
        h.check(DefaultMutableTreeNodeTest.Q.getPreviousNode(), DefaultMutableTreeNodeTest.J);
        h.check(DefaultMutableTreeNodeTest.Q.getNextNode(), DefaultMutableTreeNodeTest.R);
        h.check(DefaultMutableTreeNodeTest.P.getPreviousNode(), DefaultMutableTreeNodeTest.V);
        h.check(DefaultMutableTreeNodeTest.P.getNextNode(), null);
        h.check(DefaultMutableTreeNodeTest.Z.getPreviousNode(), DefaultMutableTreeNodeTest.Y);
        h.check(DefaultMutableTreeNodeTest.Z.getNextNode(), DefaultMutableTreeNodeTest.V);
        h.check(DefaultMutableTreeNodeTest.X.getPreviousNode(), DefaultMutableTreeNodeTest.W);
        h.check(DefaultMutableTreeNodeTest.X.getNextNode(), DefaultMutableTreeNodeTest.M);
        h.check(DefaultMutableTreeNodeTest.G.getPreviousNode(), DefaultMutableTreeNodeTest.C);
        h.check(DefaultMutableTreeNodeTest.G.getNextNode(), DefaultMutableTreeNodeTest.L);
    }
}

