/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class pathByAddingChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath("X");
        TreePath p2 = p1.pathByAddingChild("Y");
        harness.check(p2, new TreePath(new Object[]{"X", "Y"}));
        boolean pass = false;
        try {
            p1.pathByAddingChild(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

