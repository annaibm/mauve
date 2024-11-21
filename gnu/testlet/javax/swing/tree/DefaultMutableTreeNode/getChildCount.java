/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;

public class getChildCount
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(DefaultMutableTreeNodeTest.A.getChildCount(), 3);
        h.check(DefaultMutableTreeNodeTest.B.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.C.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.D.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.E.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.F.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.G.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.H.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.I.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.J.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.K.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.L.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.M.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.N.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.O.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.P.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.Q.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.R.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.S.getChildCount(), 2);
        h.check(DefaultMutableTreeNodeTest.T.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.U.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.V.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.W.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.X.getChildCount(), 0);
        h.check(DefaultMutableTreeNodeTest.Y.getChildCount(), 1);
        h.check(DefaultMutableTreeNodeTest.Z.getChildCount(), 0);
    }
}

