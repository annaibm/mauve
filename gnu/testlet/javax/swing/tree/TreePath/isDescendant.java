/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class isDescendant
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath(new Object[]{new Integer(1), new Integer(2), new Integer(3)});
        TreePath p2 = new TreePath(new Integer(1));
        TreePath p3 = new TreePath(new Integer(2));
        TreePath p4 = new TreePath(new Integer(3));
        TreePath p5 = new TreePath(new Object[]{new Integer(1), new Integer(2)});
        TreePath p6 = new TreePath(new Object[]{new Integer(2), new Integer(3)});
        TreePath p7 = new TreePath(new Object[]{new Integer(1), new Integer(2), new Integer(3)});
        TreePath p8 = new TreePath(new Object[]{new Integer(1), new Integer(2), new Integer(3), new Integer(4)});
        TreePath p9 = new TreePath(new Object[]{new Integer(2), new Integer(3), new Integer(4)});
        harness.check(p1.isDescendant(p2), false);
        harness.check(p1.isDescendant(p3), false);
        harness.check(p1.isDescendant(p4), false);
        harness.check(p1.isDescendant(p5), false);
        harness.check(p1.isDescendant(p6), false);
        harness.check(p1.isDescendant(p7), true);
        harness.check(p1.isDescendant(p8), true);
        harness.check(p1.isDescendant(p9), false);
        harness.check(p1.isDescendant(null), false);
    }
}

