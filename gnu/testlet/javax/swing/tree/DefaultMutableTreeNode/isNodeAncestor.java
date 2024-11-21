/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class isNodeAncestor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(MutableTreeNode)");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n2);
        n2.add(n3);
        harness.check(n2.isNodeAncestor(n1), true);
        harness.check(n2.isNodeAncestor(n2), true);
        harness.check(n3.isNodeAncestor(n1), true);
        harness.check(n3.isNodeAncestor(n2), true);
        harness.check(n3.isNodeAncestor(n3), true);
        harness.check(n1.isNodeAncestor(n2), false);
        harness.check(n1.isNodeAncestor(n3), false);
        harness.check(n1.isNodeAncestor(null), false);
    }
}

