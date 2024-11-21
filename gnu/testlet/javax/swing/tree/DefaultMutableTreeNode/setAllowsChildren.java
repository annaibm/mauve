/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class setAllowsChildren
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        n1.setAllowsChildren(false);
        harness.check(n1.getAllowsChildren(), false);
        n1.setAllowsChildren(true);
        harness.check(n1.getAllowsChildren(), true);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        n1.setAllowsChildren(false);
        harness.check(n1.getAllowsChildren(), false);
        harness.check(n1.getChildCount(), 0);
        harness.check(n2.getParent(), null);
    }
}

