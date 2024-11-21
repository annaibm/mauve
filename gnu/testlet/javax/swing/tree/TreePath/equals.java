/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath(new Integer(123));
        TreePath p2 = new TreePath(new Integer(123));
        harness.check(p1.equals(p2));
        harness.check(p2.equals(p1));
        p1 = new TreePath("Y");
        harness.check(!p1.equals(p2));
        p2 = new TreePath("Y");
        harness.check(p1.equals(p2));
    }
}

