/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class removeAllChildren
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        n1.removeAllChildren();
        harness.check(n1.getChildCount(), 0);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n2);
        n1.add(n3);
        n1.removeAllChildren();
        harness.check(n1.getChildCount(), 0);
        harness.check(n2.getParent(), null);
        harness.check(n3.getParent(), null);
    }
}

