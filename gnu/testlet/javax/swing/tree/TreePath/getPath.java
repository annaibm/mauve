/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.tree.TreePath;

public class getPath
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath("X");
        Object[] o1 = p1.getPath();
        harness.check(Arrays.equals(o1, new Object[]{"X"}));
        o1[0] = "Y";
        harness.check(p1.getLastPathComponent(), (Object)"X");
    }
}

