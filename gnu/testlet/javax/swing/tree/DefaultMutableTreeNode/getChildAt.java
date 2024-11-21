/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.tree.DefaultMutableTreeNode.DefaultMutableTreeNodeTest;

public class getChildAt
implements Testlet {
    @Override
    public void test(TestHarness h) {
        boolean ok = false;
        try {
            DefaultMutableTreeNodeTest.A.getChildAt(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ok = true;
        }
        h.check(ok, "rejects invalid index");
        ok = false;
        try {
            DefaultMutableTreeNodeTest.A.getChildAt(3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            ok = true;
        }
        h.check(ok, "rejects invalid index");
        h.checkPoint("child at position");
        h.check(DefaultMutableTreeNodeTest.A.getChildAt(0), DefaultMutableTreeNodeTest.B);
        h.check(DefaultMutableTreeNodeTest.A.getChildAt(1), DefaultMutableTreeNodeTest.C);
        h.check(DefaultMutableTreeNodeTest.A.getChildAt(2), DefaultMutableTreeNodeTest.D);
        h.check(DefaultMutableTreeNodeTest.B.getChildAt(0), DefaultMutableTreeNodeTest.E);
        h.check(DefaultMutableTreeNodeTest.B.getChildAt(1), DefaultMutableTreeNodeTest.F);
        h.check(DefaultMutableTreeNodeTest.C.getChildAt(0), DefaultMutableTreeNodeTest.G);
        h.check(DefaultMutableTreeNodeTest.D.getChildAt(0), DefaultMutableTreeNodeTest.H);
        h.check(DefaultMutableTreeNodeTest.D.getChildAt(1), DefaultMutableTreeNodeTest.I);
        h.check(DefaultMutableTreeNodeTest.E.getChildAt(0), DefaultMutableTreeNodeTest.J);
        h.check(DefaultMutableTreeNodeTest.F.getChildAt(0), DefaultMutableTreeNodeTest.K);
        h.check(DefaultMutableTreeNodeTest.G.getChildAt(0), DefaultMutableTreeNodeTest.L);
        h.check(DefaultMutableTreeNodeTest.G.getChildAt(1), DefaultMutableTreeNodeTest.M);
        h.check(DefaultMutableTreeNodeTest.H.getChildAt(0), DefaultMutableTreeNodeTest.N);
        h.check(DefaultMutableTreeNodeTest.I.getChildAt(0), DefaultMutableTreeNodeTest.O);
        h.check(DefaultMutableTreeNodeTest.I.getChildAt(1), DefaultMutableTreeNodeTest.P);
        h.check(DefaultMutableTreeNodeTest.J.getChildAt(0), DefaultMutableTreeNodeTest.Q);
        h.check(DefaultMutableTreeNodeTest.J.getChildAt(1), DefaultMutableTreeNodeTest.R);
        h.check(DefaultMutableTreeNodeTest.L.getChildAt(0), DefaultMutableTreeNodeTest.S);
        h.check(DefaultMutableTreeNodeTest.M.getChildAt(0), DefaultMutableTreeNodeTest.T);
        h.check(DefaultMutableTreeNodeTest.O.getChildAt(0), DefaultMutableTreeNodeTest.U);
        h.check(DefaultMutableTreeNodeTest.O.getChildAt(1), DefaultMutableTreeNodeTest.V);
        h.check(DefaultMutableTreeNodeTest.S.getChildAt(0), DefaultMutableTreeNodeTest.W);
        h.check(DefaultMutableTreeNodeTest.S.getChildAt(1), DefaultMutableTreeNodeTest.X);
        h.check(DefaultMutableTreeNodeTest.U.getChildAt(0), DefaultMutableTreeNodeTest.Y);
        h.check(DefaultMutableTreeNodeTest.Y.getChildAt(0), DefaultMutableTreeNodeTest.Z);
    }
}

