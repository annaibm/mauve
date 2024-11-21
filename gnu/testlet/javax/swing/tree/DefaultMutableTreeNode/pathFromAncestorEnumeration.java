/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class pathFromAncestorEnumeration
implements Testlet {
    @Override
    public void test(TestHarness h) {
        boolean ok = false;
        try {
            DefaultMutableTreeNodeTest.M.pathFromAncestorEnumeration(DefaultMutableTreeNodeTest.K);
        }
        catch (IllegalArgumentException ex) {
            ok = true;
        }
        h.check(ok, "rejects invalid arguments");
        ok = false;
        try {
            DefaultMutableTreeNodeTest.A.pathFromAncestorEnumeration(null);
        }
        catch (IllegalArgumentException ex) {
            ok = true;
        }
        h.check(ok, "rejects invalid arguments (null)");
        Enumeration<TreeNode> e = DefaultMutableTreeNodeTest.A.pathFromAncestorEnumeration(DefaultMutableTreeNodeTest.A);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.A);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
        e = DefaultMutableTreeNodeTest.S.pathFromAncestorEnumeration(DefaultMutableTreeNodeTest.A);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.A);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.C);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.G);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.L);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, DefaultMutableTreeNodeTest.S);
        DefaultMutableTreeNodeTest.checkEnumeration(h, e, null);
    }
}

