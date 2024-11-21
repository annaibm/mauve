/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class insert
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(MutableTreeNode, int)");
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        n1.insert(n2, 0);
        harness.check(n1.getChildAt(0), n2);
        n1.insert(n3, 0);
        harness.check(n1.getChildAt(0), n3);
        harness.check(n1.getChildAt(1), n2);
        n1.insert(n4, 2);
        harness.check(n1.getChildAt(0), n3);
        harness.check(n1.getChildAt(1), n2);
        harness.check(n1.getChildAt(2), n4);
        boolean pass = false;
        try {
            n1.insert(null, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        DefaultMutableTreeNode n5 = new DefaultMutableTreeNode("E");
        try {
            n1.insert(n5, -1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            n1.insert(n5, 4);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        DefaultMutableTreeNode n6 = new DefaultMutableTreeNode("F", false);
        DefaultMutableTreeNode n7 = new DefaultMutableTreeNode("G");
        pass = false;
        try {
            n6.insert(n7, 0);
        }
        catch (IllegalStateException e) {
            pass = true;
        }
        harness.check(pass);
        DefaultMutableTreeNode n8 = new DefaultMutableTreeNode("H");
        DefaultMutableTreeNode n9 = new DefaultMutableTreeNode("I");
        DefaultMutableTreeNode n10 = new DefaultMutableTreeNode("J");
        n8.add(n9);
        n9.add(n10);
        pass = false;
        try {
            n10.insert(n8, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

