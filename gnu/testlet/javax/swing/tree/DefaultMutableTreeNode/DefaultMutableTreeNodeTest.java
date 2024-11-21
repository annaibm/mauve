/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;

public class DefaultMutableTreeNodeTest
implements Testlet {
    public static DefaultMutableTreeNode A;
    public static DefaultMutableTreeNode B;
    public static DefaultMutableTreeNode C;
    public static DefaultMutableTreeNode D;
    public static DefaultMutableTreeNode E;
    public static DefaultMutableTreeNode F;
    public static DefaultMutableTreeNode G;
    public static DefaultMutableTreeNode H;
    public static DefaultMutableTreeNode I;
    public static DefaultMutableTreeNode J;
    public static DefaultMutableTreeNode K;
    public static DefaultMutableTreeNode L;
    public static DefaultMutableTreeNode M;
    public static DefaultMutableTreeNode N;
    public static DefaultMutableTreeNode O;
    public static DefaultMutableTreeNode P;
    public static DefaultMutableTreeNode Q;
    public static DefaultMutableTreeNode R;
    public static DefaultMutableTreeNode S;
    public static DefaultMutableTreeNode T;
    public static DefaultMutableTreeNode U;
    public static DefaultMutableTreeNode V;
    public static DefaultMutableTreeNode W;
    public static DefaultMutableTreeNode X;
    public static DefaultMutableTreeNode Y;
    public static DefaultMutableTreeNode Z;
    public static Vector nodes;

    public static void checkEnumeration(TestHarness h, Enumeration e, DefaultMutableTreeNode node) {
        if (node == null) {
            h.check(!e.hasMoreElements(), "enumeration has more elements");
            boolean ok = false;
            try {
                e.nextElement();
            }
            catch (NoSuchElementException ex) {
                ok = true;
            }
            h.check(ok, "throws NoSuchElementException");
        } else {
            h.check(e.hasMoreElements(), "enumeration has more elements");
            DefaultMutableTreeNode enode = (DefaultMutableTreeNode)e.nextElement();
            h.check(enode, node, "correct node as next element");
            h.debug("expected: " + (String)node.getUserObject());
            h.debug("got     : " + (String)enode.getUserObject());
        }
    }

    private void checkRoot(TestHarness h, DefaultMutableTreeNode node, boolean isRoot) {
        h.check(node.isRoot() == isRoot, "node is root");
    }

    private void checkIsLeaf(TestHarness h, DefaultMutableTreeNode node, boolean isLeaf2) {
        h.check(node.isLeaf() == isLeaf2, "isLeaf");
    }

    @Override
    public void test(TestHarness h) {
        this.checkRoot(h, A, true);
        this.checkRoot(h, B, false);
        this.checkRoot(h, C, false);
        this.checkRoot(h, D, false);
        this.checkRoot(h, E, false);
        this.checkRoot(h, F, false);
        this.checkRoot(h, G, false);
        this.checkRoot(h, H, false);
        this.checkRoot(h, I, false);
        this.checkRoot(h, J, false);
        this.checkRoot(h, K, false);
        this.checkRoot(h, L, false);
        this.checkRoot(h, M, false);
        this.checkRoot(h, N, false);
        this.checkRoot(h, O, false);
        this.checkRoot(h, P, false);
        this.checkRoot(h, Q, false);
        this.checkRoot(h, R, false);
        this.checkRoot(h, S, false);
        this.checkRoot(h, T, false);
        this.checkRoot(h, U, false);
        this.checkRoot(h, V, false);
        this.checkRoot(h, W, false);
        this.checkRoot(h, X, false);
        this.checkRoot(h, Y, false);
        this.checkRoot(h, Z, false);
        this.checkIsLeaf(h, A, false);
        this.checkIsLeaf(h, B, false);
        this.checkIsLeaf(h, C, false);
        this.checkIsLeaf(h, D, false);
        this.checkIsLeaf(h, E, false);
        this.checkIsLeaf(h, F, false);
        this.checkIsLeaf(h, G, false);
        this.checkIsLeaf(h, H, false);
        this.checkIsLeaf(h, I, false);
        this.checkIsLeaf(h, J, false);
        this.checkIsLeaf(h, K, true);
        this.checkIsLeaf(h, L, false);
        this.checkIsLeaf(h, M, false);
        this.checkIsLeaf(h, N, true);
        this.checkIsLeaf(h, O, false);
        this.checkIsLeaf(h, P, true);
        this.checkIsLeaf(h, Q, true);
        this.checkIsLeaf(h, R, true);
        this.checkIsLeaf(h, S, false);
        this.checkIsLeaf(h, T, true);
        this.checkIsLeaf(h, U, false);
        this.checkIsLeaf(h, V, true);
        this.checkIsLeaf(h, W, true);
        this.checkIsLeaf(h, X, true);
        this.checkIsLeaf(h, Y, false);
        this.checkIsLeaf(h, Z, true);
    }

    static {
        nodes = new Vector();
        A = new DefaultMutableTreeNode("A");
        B = new DefaultMutableTreeNode("B");
        C = new DefaultMutableTreeNode("C");
        D = new DefaultMutableTreeNode("D");
        E = new DefaultMutableTreeNode("E");
        F = new DefaultMutableTreeNode("F");
        G = new DefaultMutableTreeNode("G");
        H = new DefaultMutableTreeNode("H");
        I = new DefaultMutableTreeNode("I");
        J = new DefaultMutableTreeNode("J");
        K = new DefaultMutableTreeNode("K", false);
        L = new DefaultMutableTreeNode("L");
        M = new DefaultMutableTreeNode("M");
        N = new DefaultMutableTreeNode("N");
        O = new DefaultMutableTreeNode("O");
        P = new DefaultMutableTreeNode("P", false);
        Q = new DefaultMutableTreeNode("Q");
        R = new DefaultMutableTreeNode("R");
        S = new DefaultMutableTreeNode("S");
        T = new DefaultMutableTreeNode("T", false);
        U = new DefaultMutableTreeNode("U");
        V = new DefaultMutableTreeNode("V");
        W = new DefaultMutableTreeNode("W");
        X = new DefaultMutableTreeNode("X", false);
        Y = new DefaultMutableTreeNode("Y");
        Z = new DefaultMutableTreeNode("Z");
        A.add(B);
        A.add(C);
        A.add(D);
        B.add(E);
        B.add(F);
        C.add(G);
        D.add(H);
        D.add(I);
        E.add(J);
        F.add(K);
        G.add(L);
        G.add(M);
        H.add(N);
        I.add(O);
        I.add(P);
        J.add(Q);
        J.add(R);
        L.add(S);
        M.add(T);
        O.add(U);
        O.add(V);
        S.add(W);
        S.add(X);
        U.add(Y);
        Y.add(Z);
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);
        nodes.add(H);
        nodes.add(I);
        nodes.add(J);
        nodes.add(K);
        nodes.add(L);
        nodes.add(M);
        nodes.add(N);
        nodes.add(O);
        nodes.add(P);
        nodes.add(Q);
        nodes.add(R);
        nodes.add(S);
        nodes.add(T);
        nodes.add(U);
        nodes.add(V);
        nodes.add(W);
        nodes.add(X);
        nodes.add(Y);
        nodes.add(Z);
    }
}

