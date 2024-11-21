/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class getPathCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath("X");
        harness.check(p1.getPathCount(), 1);
        TreePath p2 = new TreePath(new Object[]{"A", "B", "C", "D", "E", "F"});
        harness.check(p2.getPathCount(), 6);
    }
}

