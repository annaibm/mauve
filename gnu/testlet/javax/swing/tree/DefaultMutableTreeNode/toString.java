/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        DefaultMutableTreeNode n0 = new DefaultMutableTreeNode(null);
        harness.check(n0.toString(), null);
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(new Integer(100));
        harness.check(n1.toString(), (Object)"100");
    }
}

