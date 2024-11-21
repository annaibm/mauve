/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class getNextLeaf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        harness.check(n1.getNextLeaf(), null);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n1.getNextLeaf(), null);
        harness.check(n2.getNextLeaf(), null);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n3);
        harness.check(n2.getNextLeaf(), n3);
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        DefaultMutableTreeNode n5 = new DefaultMutableTreeNode("E");
        n2.add(n4);
        n2.add(n5);
        harness.check(n4.getNextLeaf(), n5);
        harness.check(n5.getNextLeaf(), n3);
        harness.check(n2.getNextLeaf(), n3);
    }
}

