/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class getParentPath
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TreePath test = new TreePath("Test");
        h.check(test.getParentPath(), null);
        TreePath p = new TreePath(new Object[]{"A", "B"});
        TreePath parent = p.getParentPath();
        h.check(parent, new TreePath("A"));
        p = new TreePath(new Object[]{"A", "B", "C", "D"});
        parent = p.getParentPath();
        h.check(parent, new TreePath(new Object[]{"A", "B", "C"}));
    }
}

