/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class isNodeDescendant
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(MutableTreeNode)");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n2);
        n2.add(n3);
        harness.check(n1.isNodeDescendant(n1), true);
        harness.check(n1.isNodeDescendant(n2), true);
        harness.check(n1.isNodeDescendant(n3), true);
        harness.check(n1.isNodeDescendant(null), false);
        harness.check(n2.isNodeDescendant(n1), false);
        harness.check(n2.isNodeDescendant(n2), true);
        harness.check(n2.isNodeDescendant(n3), true);
        harness.check(n3.isNodeDescendant(n1), false);
        harness.check(n3.isNodeDescendant(n2), false);
        harness.check(n3.isNodeDescendant(n3), true);
    }
}

