/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class getIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        DefaultMutableTreeNode n5 = new DefaultMutableTreeNode("E");
        n1.add(n2);
        n1.add(n3);
        n1.add(n4);
        harness.check(n1.getIndex(n2), 0);
        harness.check(n1.getIndex(n3), 1);
        harness.check(n1.getIndex(n4), 2);
        harness.check(n1.getIndex(n5), -1);
        boolean pass = false;
        try {
            n1.getIndex(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

