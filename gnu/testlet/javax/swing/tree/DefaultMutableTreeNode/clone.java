/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("clone()");
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(200);
        Integer i3 = new Integer(300);
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(i1);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode(i2);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode(i3);
        n1.add(n2);
        n2.add(n3);
        DefaultMutableTreeNode c = (DefaultMutableTreeNode)n2.clone();
        harness.check(c.getUserObject() == i2);
        harness.check(c.getChildCount(), 0);
        harness.check(c.getDepth(), 0);
        harness.check(c.getParent(), null);
    }
}

