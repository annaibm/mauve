/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.NoSuchElementException;
import javax.swing.tree.DefaultMutableTreeNode;

public class getFirstChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("A");
        boolean pass = false;
        try {
            n1.getFirstChild();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("B");
        n1.add(n2);
        harness.check(n1.getFirstChild(), n2);
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("C");
        n1.add(n3);
        harness.check(n1.getFirstChild(), n2);
        n1.remove(0);
        harness.check(n1.getFirstChild(), n3);
    }
}

