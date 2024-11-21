/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class isNodeSibling
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        harness.check(n1.isNodeSibling(n1), true);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n2.isNodeSibling(n1), false);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n3);
        harness.check(n2.isNodeSibling(n3), true);
        harness.check(n3.isNodeSibling(n2), true);
    }
}

