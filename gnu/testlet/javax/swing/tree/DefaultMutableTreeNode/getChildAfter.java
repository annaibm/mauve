/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class getChildAfter
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("D");
        n1.add(n2);
        n1.add(n3);
        h.check(n1.getChildAfter(n2), n3);
        h.check(n1.getChildAfter(n3), null);
        boolean ok = false;
        try {
            n1.getChildAfter(null);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        h.check(ok);
        ok = false;
        try {
            n4.getChildAfter(n1);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        h.check(ok);
    }
}

