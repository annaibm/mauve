/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class getParent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        harness.check(n1.getParent(), null);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n2.getParent(), n1);
        n2.setParent(null);
        harness.check(n2.getParent(), null);
        harness.check(n1.getChildCount(), 1);
    }
}

