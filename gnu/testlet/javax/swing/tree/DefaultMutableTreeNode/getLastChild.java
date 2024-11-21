/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.NoSuchElementException;
import javax.swing.tree.DefaultMutableTreeNode;

public class getLastChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        boolean pass = false;
        try {
            n1.getLastChild();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n1.getLastChild(), n2);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n3);
        harness.check(n1.getLastChild(), n3);
        n1.remove(1);
        harness.check(n1.getLastChild(), n2);
    }
}

