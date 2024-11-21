/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class getPreviousLeaf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        harness.check(n1.getPreviousLeaf(), null);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n1.getPreviousLeaf(), null);
        harness.check(n2.getPreviousLeaf(), null);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n3);
        harness.check(n3.getPreviousLeaf(), n2);
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        DefaultMutableTreeNode n5 = new DefaultMutableTreeNode("E");
        n2.add(n4);
        n2.add(n5);
        harness.check(n4.getPreviousLeaf(), null);
        harness.check(n5.getPreviousLeaf(), n4);
        harness.check(n2.getPreviousLeaf(), null);
        harness.check(n3.getPreviousLeaf(), n5);
    }
}

