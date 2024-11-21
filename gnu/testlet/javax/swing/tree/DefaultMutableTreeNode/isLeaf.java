/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class isLeaf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        harness.check(n1.isLeaf(), true);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B", false);
        n1.add(n2);
        harness.check(n1.isLeaf(), false);
        harness.check(n2.isLeaf(), true);
        n1.remove(n2);
        harness.check(n1.isLeaf(), true);
    }
}

