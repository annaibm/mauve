/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;

public class getAllowsChildren
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(DefaultMutableTreeNodeTest.A.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.B.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.C.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.D.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.E.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.F.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.G.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.H.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.I.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.J.getAllowsChildren());
        h.check(!DefaultMutableTreeNodeTest.K.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.L.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.M.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.N.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.O.getAllowsChildren());
        h.check(!DefaultMutableTreeNodeTest.P.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.Q.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.R.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.S.getAllowsChildren());
        h.check(!DefaultMutableTreeNodeTest.T.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.U.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.V.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.W.getAllowsChildren());
        h.check(!DefaultMutableTreeNodeTest.X.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.Y.getAllowsChildren());
        h.check(DefaultMutableTreeNodeTest.Z.getAllowsChildren());
    }
}

