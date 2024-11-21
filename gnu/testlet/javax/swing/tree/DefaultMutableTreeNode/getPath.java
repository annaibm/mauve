/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;
import javax.swing.tree.TreeNode;

public class getPath
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TreeNode[] path = DefaultMutableTreeNodeTest.A.getPath();
        h.check(path.length, 1, "array length 1");
        h.check(path[0], DefaultMutableTreeNodeTest.A, "correct tree node 1");
        path = DefaultMutableTreeNodeTest.U.getPath();
        h.check(path.length, 5, "array length 2");
        h.check(path[0], DefaultMutableTreeNodeTest.A, "correct tree node 2");
        h.check(path[1], DefaultMutableTreeNodeTest.D, "correct tree node 3");
        h.check(path[2], DefaultMutableTreeNodeTest.I, "correct tree node 4");
        h.check(path[3], DefaultMutableTreeNodeTest.O, "correct tree node 5");
        h.check(path[4], DefaultMutableTreeNodeTest.U, "correct tree node 6");
    }
}

