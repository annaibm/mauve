/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class isNodeChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(MutableTreeNode)");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n2);
        harness.check(n1.isNodeChild(n2), true);
        harness.check(n1.isNodeChild(n3), false);
        harness.check(n1.isNodeChild(null), false);
        harness.check(n1.isNodeChild(n1), false);
    }
}

