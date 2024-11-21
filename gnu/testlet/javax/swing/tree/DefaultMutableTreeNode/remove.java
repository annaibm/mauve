/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(int)");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        n1.add(n2);
        n1.add(n3);
        n1.add(n4);
        n1.remove(2);
        harness.check(n1.getChildCount(), 2);
        harness.check(n1.isNodeChild(n4), false);
        harness.check(n4.getParent(), null);
        boolean pass = false;
        try {
            n1.remove(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            n1.remove(n1.getChildCount());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(MutableTreeNode)");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        n1.add(n2);
        n1.add(n3);
        n1.add(n4);
        n1.remove(n4);
        harness.check(n1.getChildCount(), 2);
        harness.check(n1.isNodeChild(n4), false);
        harness.check(n4.getParent(), null);
        boolean pass = false;
        try {
            n1.remove(new DefaultMutableTreeNode("Z"));
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            n1.remove(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

