/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class add
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("(MutableTreeNode)");
        DefaultMutableTreeNode a = new DefaultMutableTreeNode();
        DefaultMutableTreeNode b = new DefaultMutableTreeNode();
        DefaultMutableTreeNode c = new DefaultMutableTreeNode(null, false);
        boolean ok = false;
        try {
            a.add(null);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        h.check(ok);
        ok = false;
        try {
            c.add(a);
        }
        catch (IllegalStateException e) {
            ok = true;
        }
        h.check(ok);
        a.add(b);
        a.add(c);
        h.check(a.isNodeChild(b));
        h.check(b.getParent(), a);
        h.check(a.isNodeChild(c));
        h.check(c.getParent(), a);
        h.check(!b.isNodeChild(c));
        b.add(c);
        h.check(a.isNodeChild(b));
        h.check(!a.isNodeChild(c));
        h.check(b.isNodeChild(c));
        boolean pass = false;
        try {
            a.add(a);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        h.check(pass);
        pass = false;
        try {
            b.add(a);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        h.check(pass);
    }
}

