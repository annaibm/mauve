/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class children
implements Testlet {
    @Override
    public void test(TestHarness h) {
        Enumeration<TreeNode> e = DefaultMutableTreeNodeTest.A.children();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.B);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.C);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.D);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
        e = DefaultMutableTreeNodeTest.G.children();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.L);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.M);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
        e = DefaultMutableTreeNodeTest.K.children();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
        e = DefaultMutableTreeNodeTest.L.children();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.S);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
        e = DefaultMutableTreeNodeTest.Z.children();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
    }
}

