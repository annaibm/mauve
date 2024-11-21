/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultMutableTreeNode;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness h) {
        this.testConstructor1(h);
        this.testConstructor2(h);
        this.testConstructor3(h);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        DefaultMutableTreeNode n = new DefaultMutableTreeNode();
        harness.check(n.getUserObject(), null);
        harness.check(n.getAllowsChildren(), true);
        harness.check(n.getLevel(), 0);
        harness.check(n.getChildCount(), 0);
        harness.check(n.children(), DefaultMutableTreeNode.EMPTY_ENUMERATION);
        harness.check(n.getDepth(), 0);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Object)");
        DefaultMutableTreeNode n = new DefaultMutableTreeNode("ABC");
        harness.check(n.getUserObject(), (Object)"ABC");
        harness.check(n.getAllowsChildren(), true);
        harness.check(n.getLevel(), 0);
        harness.check(n.getChildCount(), 0);
        harness.check(n.children(), DefaultMutableTreeNode.EMPTY_ENUMERATION);
        harness.check(n.getDepth(), 0);
        n = new DefaultMutableTreeNode(null);
        harness.check(n.getUserObject(), null);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Object, boolean)");
        DefaultMutableTreeNode n = new DefaultMutableTreeNode("ABC", false);
        harness.check(n.getUserObject(), (Object)"ABC");
        harness.check(n.getAllowsChildren(), false);
        harness.check(n.getLevel(), 0);
        harness.check(n.getChildCount(), 0);
        harness.check(n.children(), DefaultMutableTreeNode.EMPTY_ENUMERATION);
        harness.check(n.getDepth(), 0);
        n = new DefaultMutableTreeNode(null, true);
        harness.check(n.getUserObject(), null);
        harness.check(n.getAllowsChildren(), true);
    }
}

