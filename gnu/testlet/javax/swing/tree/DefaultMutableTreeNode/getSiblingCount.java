/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class getSiblingCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        harness.check(n1.getSiblingCount(), 1);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n2.getSiblingCount(), 1);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n3);
        harness.check(n2.getSiblingCount(), 2);
        harness.check(n3.getSiblingCount(), 2);
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        n1.add(n4);
        harness.check(n2.getSiblingCount(), 3);
        harness.check(n3.getSiblingCount(), 3);
        harness.check(n4.getSiblingCount(), 3);
    }
}

