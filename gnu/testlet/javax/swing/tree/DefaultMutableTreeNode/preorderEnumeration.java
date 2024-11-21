/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class preorderEnumeration
implements Testlet {
    @Override
    public void test(TestHarness h) {
        Enumeration<TreeNode> e = DefaultMutableTreeNodeTest.G.preorderEnumeration();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.G);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.L);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.S);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.W);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.X);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.M);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.T);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
        e = DefaultMutableTreeNodeTest.A.preorderEnumeration();
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.A);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.B);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.E);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.J);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.Q);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.R);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.F);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.K);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.C);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.G);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.L);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.S);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.W);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.X);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.M);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.T);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.D);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.H);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.N);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.I);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.O);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.U);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.Y);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.Z);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.V);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.P);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
    }
}

