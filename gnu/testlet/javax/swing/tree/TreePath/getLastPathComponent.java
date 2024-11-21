/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class getLastPathComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath(new Object[]{"A", "B", "C"});
        harness.check(p1.getLastPathComponent(), (Object)"C");
    }
}

